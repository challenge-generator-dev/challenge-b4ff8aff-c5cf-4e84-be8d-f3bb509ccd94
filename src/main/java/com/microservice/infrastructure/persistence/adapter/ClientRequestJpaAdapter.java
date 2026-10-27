package com.microservice.infrastructure.persistence.adapter;

import com.microservice.domain.model.ClientRequest;
import com.microservice.domain.ports.out.ClientRequestPersistencePort;
import com.microservice.infrastructure.persistence.entity.ClientRequestEntity;
import com.microservice.infrastructure.persistence.repository.ClientRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ClientRequestJpaAdapter implements ClientRequestPersistencePort {

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestJpaAdapter.class);

    private final ClientRequestRepository repository;

    public ClientRequestJpaAdapter(ClientRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public ClientRequest save(ClientRequest request) {
        logger.debug("Persistiendo solicitud: {}", request.requestId());

        ClientRequestEntity entity = toEntity(request);
        ClientRequestEntity savedEntity = repository.save(entity);

        logger.debug("Solicitud persistida exitosamente: {}", savedEntity.getRequestId());
        return toDomain(savedEntity);
    }

    @Override
    public Optional<ClientRequest> findById(UUID requestId) {
        logger.debug("Buscando solicitud por ID: {}", requestId);
        return repository.findById(requestId).map(this::toDomain);
    }

    @Override
    public List<ClientRequest> findAll() {
        logger.debug("Recuperando todas las solicitudes");
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(UUID requestId) {
        logger.debug("Eliminando solicitud por ID: {}", requestId);
        repository.deleteById(requestId);
    }

    @Override
    public List<ClientRequest> findByClientId(String clientId) {
        logger.debug("Buscando solicitudes por clientId: {}", clientId);
        return repository.findByClientId(clientId).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientRequest> findByStatus(String status) {
        logger.debug("Buscando solicitudes por status: {}", status);
        return repository.findByStatus(status).stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private ClientRequestEntity toEntity(ClientRequest domain) {
        ClientRequestEntity entity = new ClientRequestEntity();
        entity.setRequestId(domain.requestId());
        entity.setClientId(domain.clientId());
        entity.setRequestType(domain.requestType());
        entity.setDescription(domain.description());
        entity.setStatus(domain.status());
        entity.setCreatedAt(domain.createdAt());
        entity.setUpdatedAt(domain.updatedAt());
        entity.setMetadata(domain.metadata());
        return entity;
    }

    private ClientRequest toDomain(ClientRequestEntity entity) {
        return new ClientRequest(
                entity.getRequestId(),
                entity.getClientId(),
                entity.getRequestType(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getCreatedAt() != null ? entity.getCreatedAt() : LocalDateTime.now(),
                entity.getUpdatedAt() != null ? entity.getUpdatedAt() : LocalDateTime.now(),
                entity.getMetadata()
        );
    }
}