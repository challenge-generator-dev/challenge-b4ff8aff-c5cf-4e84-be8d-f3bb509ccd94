package com.microservice.application.usecase;

import com.microservice.domain.model.ClientRequest;
import com.microservice.domain.ports.in.ClientRequestUseCase;
import com.microservice.domain.ports.out.ClientRequestPersistencePort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientRequestService implements ClientRequestUseCase {

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestService.class);

    private final ClientRequestPersistencePort persistencePort;

    public ClientRequestService(ClientRequestPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }

    @Override
    @Transactional
    public ClientRequest createRequest(@Valid ClientRequest request) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        MDC.put("clientId", request.clientId());

        logger.info("Iniciando creacion de solicitud para cliente: {}", request.clientId());

        ClientRequest requestWithId = new ClientRequest(
                requestId,
                request.clientId(),
                request.requestType(),
                request.description(),
                "PENDING",
                LocalDateTime.now(),
                LocalDateTime.now(),
                request.metadata()
        );

        ClientRequest savedRequest = persistencePort.save(requestWithId);

        logger.info("Solicitud creada exitosamente con ID: {}", savedRequest.requestId());
        MDC.clear();

        return savedRequest;
    }

    @Override
    public Optional<ClientRequest> getRequestById(UUID requestId) {
        MDC.put("requestId", requestId.toString());
        logger.debug("Obteniendo solicitud por ID: {}", requestId);

        Optional<ClientRequest> result = persistencePort.findById(requestId);

        result.ifPresent(req -> 
                logger.debug("Solicitud encontrada: tipo={}, cliente={}", 
                        req.requestType(), req.clientId())
        );

        MDC.clear();
        return result;
    }

    @Override
    public List<ClientRequest> getAllRequests() {
        logger.debug("Obteniendo todas las solicitudes");
        List<ClientRequest> requests = persistencePort.findAll();
        logger.info("Total de solicitudes recuperadas: {}", requests.size());
        return requests;
    }

    @Override
    @Transactional
    public ClientRequest updateRequestStatus(UUID requestId, String newStatus) {
        MDC.put("requestId", requestId.toString());
        logger.info("Actualizando estado de solicitud a: {}", newStatus);

        Optional<ClientRequest> existingRequest = persistencePort.findById(requestId);

        if (existingRequest.isEmpty()) {
            logger.error("Solicitud no encontrada para actualizacion: {}", requestId);
            MDC.clear();
            throw new IllegalArgumentException("Solicitud no encontrada: " + requestId);
        }

        ClientRequest request = existingRequest.get();
        ClientRequest updatedRequest = request.withStatus(newStatus);

        logger.debug("Solicitud actualizada: {} -> {}", request.status(), newStatus);

        ClientRequest savedRequest = persistencePort.save(updatedRequest);
        logger.info("Estado de solicitud actualizado exitosamente");

        MDC.clear();
        return savedRequest;
    }

    @Override
    @Transactional
    public void deleteRequest(UUID requestId) {
        MDC.put("requestId", requestId.toString());
        logger.info("Eliminando solicitud: {}", requestId);

        if (!persistencePort.findById(requestId).isPresent()) {
            logger.error("Solicitud no encontrada para eliminacion: {}", requestId);
            MDC.clear();
            throw new IllegalArgumentException("Solicitud no encontrada: " + requestId);
        }

        persistencePort.deleteById(requestId);
        logger.info("Solicitud eliminada exitosamente");

        MDC.clear();
    }

    @Override
    public List<ClientRequest> getRequestsByClientId(String clientId) {
        MDC.put("clientId", clientId);
        logger.debug("Obteniendo solicitudes para cliente: {}", clientId);

        List<ClientRequest> requests = persistencePort.findByClientId(clientId);
        logger.info("Total de solicitudes para cliente {}: {}", clientId, requests.size());

        MDC.clear();
        return requests;
    }

    @Override
    public List<ClientRequest> getRequestsByStatus(String status) {
        MDC.put("status", status);
        logger.debug("Obteniendo solicitudes con estado: {}", status);

        List<ClientRequest> requests = persistencePort.findByStatus(status);
        logger.info("Total de solicitudes con estado {}: {}", status, requests.size());

        MDC.clear();
        return requests;
    }
}