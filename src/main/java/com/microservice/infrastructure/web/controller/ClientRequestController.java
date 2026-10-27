package com.microservice.infrastructure.web.controller;

import com.microservice.domain.model.ClientRequest;
import com.microservice.domain.ports.in.ClientRequestUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/client-requests")
public class ClientRequestController {

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestController.class);
    private final ClientRequestUseCase clientRequestUseCase;

    public ClientRequestController(ClientRequestUseCase clientRequestUseCase) {
        this.clientRequestUseCase = clientRequestUseCase;
    }

    @PostMapping
    public ResponseEntity<ClientRequest> createRequest(@Valid @RequestBody ClientRequest request) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Creating new client request for clientId: {}", request.clientId());
        try {
            ClientRequest created = clientRequestUseCase.createRequest(request);
            logger.info("Client request created successfully with id: {}", created.id());
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            logger.error("Error creating client request: {}", e.getMessage(), e);
            throw e;
        } finally {
            MDC.remove("requestId");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientRequest> getRequestById(@PathVariable UUID id) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Fetching client request with id: {}", id);
        try {
            return clientRequestUseCase.getRequestById(id)
                .map(request -> {
                    logger.info("Client request found: {}", id);
                    return ResponseEntity.ok(request);
                })
                .orElseGet(() -> {
                    logger.warn("Client request not found: {}", id);
                    return ResponseEntity.notFound().build();
                });
        } finally {
            MDC.remove("requestId");
        }
    }

    @GetMapping
    public ResponseEntity<List<ClientRequest>> getAllRequests() {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Fetching all client requests");
        try {
            List<ClientRequest> requests = clientRequestUseCase.getAllRequests();
            logger.info("Retrieved {} client requests", requests.size());
            return ResponseEntity.ok(requests);
        } finally {
            MDC.remove("requestId");
        }
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ClientRequest> updateRequestStatus(
            @PathVariable UUID id,
            @RequestParam String newStatus) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Updating status for client request id: {} to status: {}", id, newStatus);
        try {
            ClientRequest updated = clientRequestUseCase.updateRequestStatus(id, newStatus);
            logger.info("Client request status updated successfully: {}", id);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            logger.error("Error updating client request status: {}", e.getMessage(), e);
            throw e;
        } finally {
            MDC.remove("requestId");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable UUID id) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Deleting client request with id: {}", id);
        try {
            clientRequestUseCase.deleteRequest(id);
            logger.info("Client request deleted successfully: {}", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting client request: {}", e.getMessage(), e);
            throw e;
        } finally {
            MDC.remove("requestId");
        }
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ClientRequest>> getRequestsByClientId(@PathVariable String clientId) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Fetching client requests for clientId: {}", clientId);
        try {
            List<ClientRequest> requests = clientRequestUseCase.getRequestsByClientId(clientId);
            logger.info("Retrieved {} requests for clientId: {}", requests.size(), clientId);
            return ResponseEntity.ok(requests);
        } finally {
            MDC.remove("requestId");
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ClientRequest>> getRequestsByStatus(@PathVariable String status) {
        String requestId = UUID.randomUUID().toString();
        MDC.put("requestId", requestId);
        logger.info("Fetching client requests with status: {}", status);
        try {
            List<ClientRequest> requests = clientRequestUseCase.getRequestsByStatus(status);
            logger.info("Retrieved {} requests with status: {}", requests.size(), status);
            return ResponseEntity.ok(requests);
        } finally {
            MDC.remove("requestId");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        logger.error("Unhandled exception in controller: {}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("An error occurred processing the request: " + e.getMessage());
    }
}