package com.microservice.infrastructure.persistence.repository;

import com.microservice.infrastructure.persistence.entity.ClientRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRequestRepository extends JpaRepository<ClientRequestEntity, UUID> {

    List<ClientRequestEntity> findByClientId(String clientId);

    List<ClientRequestEntity> findByStatus(String status);

    @Query("SELECT cr FROM ClientRequestEntity cr WHERE cr.clientId = :clientId AND cr.status = :status")
    List<ClientRequestEntity> findByClientIdAndStatus(
            @Param("clientId") String clientId,
            @Param("status") String status
    );

    @Query("SELECT cr FROM ClientRequestEntity cr WHERE cr.createdAt >= :startDate")
    List<ClientRequestEntity> findByCreatedAtAfter(
            @Param("startDate") java.time.LocalDateTime startDate
    );

    boolean existsByClientIdAndStatus(String clientId, String status);
}