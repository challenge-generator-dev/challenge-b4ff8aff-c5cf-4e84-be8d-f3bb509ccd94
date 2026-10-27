package com.microservice.infrastructure.persistence.entity;


import com.microservice.domain.model.ClientRequest;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "client_requests", indexes = {
    @Index(name = "idx_client_id", columnList = "clientId"),
    @Index(name = "idx_status", columnList = "status"),
    @Index(name = "idx_created_at", columnList = "createdAt")
})
public class ClientRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String clientId;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(length = 500)
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "request_type", length = 100)
    private String requestType;

    @Column(columnDefinition = "TEXT")
    private String metadata;

    public ClientRequestEntity() {
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public static ClientRequestEntity fromDomain(com.microservice.domain.model.ClientRequest domain) {
        if (domain == null) {
            return null;
        }
        ClientRequestEntity entity = new ClientRequestEntity();
        entity.setId(domain.id());
        entity.setClientId(domain.clientId());
        entity.setStatus(domain.status());
        entity.setDescription(domain.description());
        entity.setRequestType(domain.requestType());
        entity.setMetadata(domain.metadata());
        if (domain.createdAt() != null) {
            entity.setCreatedAt(domain.createdAt());
        }
        if (domain.updatedAt() != null) {
            entity.setUpdatedAt(domain.updatedAt());
        }
        return entity;
    }

    public com.microservice.domain.model.ClientRequest toDomain() {
        return new com.microservice.domain.model.ClientRequest(
            this.id,
            this.clientId,
            this.status,
            this.description,
            this.requestType,
            this.metadata,
            this.createdAt,
            this.updatedAt
        );
    }
}