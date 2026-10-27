package com.microservice.domain.ports.out;

import com.microservice.domain.model.ClientRequest;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRequestPersistencePort {
    ClientRequest save(ClientRequest request);
    Optional<ClientRequest> findById(UUID requestId);
    List<ClientRequest> findAll();
    void deleteById(UUID requestId);
    List<ClientRequest> findByClientId(String clientId);
    List<ClientRequest> findByStatus(String status);
}