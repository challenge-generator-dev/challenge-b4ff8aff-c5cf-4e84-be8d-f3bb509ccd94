package com.microservice.domain.ports.in;

import com.microservice.domain.model.ClientRequest;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRequestUseCase {
    ClientRequest createRequest(@Valid ClientRequest request);
    Optional<ClientRequest> getRequestById(UUID requestId);
    List<ClientRequest> getAllRequests();
    ClientRequest updateRequestStatus(UUID requestId, String newStatus);
    void deleteRequest(UUID requestId);
    List<ClientRequest> getRequestsByClientId(String clientId);
    List<ClientRequest> getRequestsByStatus(String status);
}