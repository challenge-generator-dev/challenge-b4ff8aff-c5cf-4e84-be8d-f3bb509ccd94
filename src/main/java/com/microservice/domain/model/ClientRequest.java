package com.microservice.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ClientRequest(
    @NotNull(message = "El ID de la solicitud no puede ser nulo")
    UUID requestId,

    @NotBlank(message = "El ID del cliente no puede estar vacío")
    @Size(max = 50, message = "El ID del cliente no puede exceder 50 caracteres")
    String clientId,

    @NotBlank(message = "El tipo de solicitud no puede estar vacío")
    @Size(max = 30, message = "El tipo de solicitud no puede exceder 30 caracteres")
    String requestType,

    @NotNull(message = "El monto no puede ser nulo")
    @Positive(message = "El monto debe ser positivo")
    BigDecimal amount,

    @NotBlank(message = "El estado de la solicitud no puede estar vacío")
    @Size(max = 20, message = "El estado no puede exceder 20 caracteres")
    String status,

    @NotNull(message = "La fecha de creación no puede ser nula")
    LocalDateTime createdAt,

    LocalDateTime updatedAt,

    @NotBlank(message = "El requestId de trazabilidad no puede estar vacío")
    @Size(max = 100, message = "El requestId de trazabilidad no puede exceder 100 caracteres")
    String traceId
) {
    public ClientRequest {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
        if (traceId == null || traceId.isBlank()) {
            traceId = UUID.randomUUID().toString();
        }
    }

    public ClientRequest withStatus(String newStatus) {
        return new ClientRequest(
            this.requestId,
            this.clientId,
            this.requestType,
            this.amount,
            newStatus,
            this.createdAt,
            LocalDateTime.now(),
            this.traceId
        );
    }
}