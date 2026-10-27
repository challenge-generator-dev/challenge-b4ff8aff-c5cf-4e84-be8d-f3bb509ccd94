package com.microservice.application.usecase;

import com.microservice.domain.model.ClientRequest;
import com.microservice.domain.ports.out.ClientRequestPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ClientRequestService - Tests Unitarios")
class ClientRequestServiceTest {

    @Mock
    private ClientRequestPersistencePort persistencePort;

    @InjectMocks
    private ClientRequestService clientRequestService;

    private ClientRequest sampleRequest;
    private UUID sampleRequestId;
    private String sampleClientId;
    private String sampleStatus;

    @BeforeEach
    void setUp() {
        sampleRequestId = UUID.randomUUID();
        sampleClientId = "CLIENT-001";
        sampleStatus = "PENDING";
        
        sampleRequest = new ClientRequest(
            sampleRequestId,
            sampleClientId,
            "Test request description",
            sampleStatus,
            java.time.LocalDateTime.now(),
            java.time.LocalDateTime.now()
        );
    }

    @Nested
    @DisplayName("Create Request Tests")
    class CreateRequestTests {

        @Test
        @DisplayName("Debe crear una solicitud exitosamente")
        void shouldCreateRequestSuccessfully() {
            ClientRequest newRequest = new ClientRequest(
                null,
                sampleClientId,
                "New request description",
                "PENDING",
                null,
                null
            );

            ClientRequest savedRequest = new ClientRequest(
                UUID.randomUUID(),
                sampleClientId,
                "New request description",
                "PENDING",
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
            );

            when(persistencePort.save(any(ClientRequest.class))).thenReturn(savedRequest);

            ClientRequest result = clientRequestService.createRequest(newRequest);

            assertThat(result).isNotNull();
            assertThat(result.id()).isNotNull();
            assertThat(result.clientId()).isEqualTo(sampleClientId);
            assertThat(result.status()).isEqualTo("PENDING");

            verify(persistencePort, times(1)).save(any(ClientRequest.class));
        }

        @Test
        @DisplayName("Debe propagar excepción cuando persistencePort falla en save")
        void shouldPropagateExceptionWhenPersistencePortFails() {
            ClientRequest newRequest = new ClientRequest(
                null,
                sampleClientId,
                "Test",
                "PENDING",
                null,
                null
            );

            when(persistencePort.save(any(ClientRequest.class)))
                .thenThrow(new RuntimeException("Database connection failed"));

            assertThatThrownBy(() -> clientRequestService.createRequest(newRequest))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Database connection failed");

            verify(persistencePort, times(1)).save(any(ClientRequest.class));
        }
    }

    @Nested
    @DisplayName("Get Request Tests")
    class GetRequestTests {

        @Test
        @DisplayName("Debe obtener solicitud por ID exitosamente")
        void shouldGetRequestByIdSuccessfully() {
            when(persistencePort.findById(sampleRequestId)).thenReturn(Optional.of(sampleRequest));

            Optional<ClientRequest> result = clientRequestService.getRequestById(sampleRequestId);

            assertThat(result).isPresent();
            assertThat(result.get().id()).isEqualTo(sampleRequestId);
            assertThat(result.get().clientId()).isEqualTo(sampleClientId);

            verify(persistencePort, times(1)).findById(sampleRequestId);
        }

        @Test
        @DisplayName("Debe retornar Optional vacío cuando solicitud no existe")
        void shouldReturnEmptyWhenRequestNotFound() {
            UUID nonExistentId = UUID.randomUUID();
            when(persistencePort.findById(nonExistentId)).thenReturn(Optional.empty());

            Optional<ClientRequest> result = clientRequestService.getRequestById(nonExistentId);

            assertThat(result).isEmpty();

            verify(persistencePort, times(1)).findById(nonExistentId);
        }

        @Test
        @DisplayName("Debe obtener todas las solicitudes")
        void shouldGetAllRequests() {
            ClientRequest request2 = new ClientRequest(
                UUID.randomUUID(),
                "CLIENT-002",
                "Second request",
                "COMPLETED",
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
            );

            List<ClientRequest> requests = Arrays.asList(sampleRequest, request2);
            when(persistencePort.findAll()).thenReturn(requests);

            List<ClientRequest> result = clientRequestService.getAllRequests();

            assertThat(result).hasSize(2);
            assertThat(result).containsExactlyInAnyOrder(sampleRequest, request2);

            verify(persistencePort, times(1)).findAll();
        }
    }

    @Nested
    @DisplayName("Update Request Tests")
    class UpdateRequestTests {

        @Test
        @DisplayName("Debe actualizar estado de solicitud exitosamente")
        void shouldUpdateRequestStatusSuccessfully() {
            String newStatus = "APPROVED";
            ClientRequest updatedRequest = new ClientRequest(
                sampleRequestId,
                sampleClientId,
                sampleRequest.description(),
                newStatus,
                sampleRequest.createdAt(),
                java.time.LocalDateTime.now()
            );

            when(persistencePort.findById(sampleRequestId)).thenReturn(Optional.of(sampleRequest));
            when(persistencePort.save(any(ClientRequest.class))).thenReturn(updatedRequest);

            ClientRequest result = clientRequestService.updateRequestStatus(sampleRequestId, newStatus);

            assertThat(result).isNotNull();
            assertThat(result.status()).isEqualTo(newStatus);

            ArgumentCaptor<ClientRequest> requestCaptor = ArgumentCaptor.forClass(ClientRequest.class);
            verify(persistencePort).save(requestCaptor.capture());
            assertThat(requestCaptor.getValue().status()).isEqualTo(newStatus);
        }

        @Test
        @DisplayName("Debe lanzar excepción al actualizar solicitud inexistente")
        void shouldThrowExceptionWhenUpdatingNonExistentRequest() {
            UUID nonExistentId = UUID.randomUUID();
            when(persistencePort.findById(nonExistentId)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> 
                clientRequestService.updateRequestStatus(nonExistentId, "APPROVED"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Request not found");

            verify(persistencePort, times(1)).findById(nonExistentId);
            verify(persistencePort, never()).save(any(ClientRequest.class));
        }
    }

    @Nested
    @DisplayName("Delete Request Tests")
    class DeleteRequestTests {

        @Test
        @DisplayName("Debe eliminar solicitud exitosamente")
        void shouldDeleteRequestSuccessfully() {
            when(persistencePort.findById(sampleRequestId)).thenReturn(Optional.of(sampleRequest));
            doNothing().when(persistencePort).deleteById(sampleRequestId);

            clientRequestService.deleteRequest(sampleRequestId);

            verify(persistencePort, times(1)).findById(sampleRequestId);
            verify(persistencePort, times(1)).deleteById(sampleRequestId);
        }

        @Test
        @DisplayName("Debe lanzar excepción al eliminar solicitud inexistente")
        void shouldThrowExceptionWhenDeletingNonExistentRequest() {
            UUID nonExistentId = UUID.randomUUID();
            when(persistencePort.findById(nonExistentId)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> clientRequestService.deleteRequest(nonExistentId))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Request not found");

            verify(persistencePort, times(1)).findById(nonExistentId);
            verify(persistencePort, never()).deleteById(any(UUID.class));
        }
    }

    @Nested
    @DisplayName("Query Tests")
    class QueryTests {

        @Test
        @DisplayName("Debe obtener solicitudes por clientId")
        void shouldGetRequestsByClientId() {
            List<ClientRequest> requests = Arrays.asList(
                sampleRequest,
                new ClientRequest(
                    UUID.randomUUID(),
                    sampleClientId,
                    "Second request",
                    "COMPLETED",
                    java.time.LocalDateTime.now(),
                    java.time.LocalDateTime.now()
                )
            );

            when(persistencePort.findByClientId(sampleClientId)).thenReturn(requests);

            List<ClientRequest> result = clientRequestService.getRequestsByClientId(sampleClientId);

            assertThat(result).hasSize(2);
            assertThat(result).allMatch(r -> r.clientId().equals(sampleClientId));

            verify(persistencePort, times(1)).findByClientId(sampleClientId);
        }

        @Test
        @DisplayName("Debe obtener solicitudes por status")
        void shouldGetRequestsByStatus() {
            List<ClientRequest> requests = Arrays.asList(sampleRequest);

            when(persistencePort.findByStatus(sampleStatus)).thenReturn(requests);

            List<ClientRequest> result = clientRequestService.getRequestsByStatus(sampleStatus);

            assertThat(result).hasSize(1);
            assertThat(result).allMatch(r -> r.status().equals(sampleStatus));

            verify(persistencePort, times(1)).findByStatus(sampleStatus);
        }

        @Test
        @DisplayName("Debe retornar lista vacía cuando no hay solicitudes para cliente")
        void shouldReturnEmptyListWhenNoRequestsForClient() {
            when(persistencePort.findByClientId("NON-EXISTENT")).thenReturn(Arrays.asList());

            List<ClientRequest> result = clientRequestService.getRequestsByClientId("NON-EXISTENT");

            assertThat(result).isEmpty();

            verify(persistencePort, times(1)).findByClientId("NON-EXISTENT");
        }

        @Test
        @DisplayName("Debe retornar lista vacía cuando no hay solicitudes con ese status")
        void shouldReturnEmptyListWhenNoRequestsWithStatus() {
            when(persistencePort.findByStatus("NON-EXISTENT-STATUS")).thenReturn(Arrays.asList());

            List<ClientRequest> result = clientRequestService.getRequestsByStatus("NON-EXISTENT-STATUS");

            assertThat(result).isEmpty();

            verify(persistencePort, times(1)).findByStatus("NON-EXISTENT-STATUS");
        }
    }

    @Nested
    @DisplayName("Integration Tests - Multiple Operations")
    class IntegrationTests {

        @Test
        @DisplayName("Debe crear, buscar y actualizar solicitud en secuencia")
        void shouldCreateFindAndUpdateRequestInSequence() {
            ClientRequest newRequest = new ClientRequest(
                null,
                sampleClientId,
                "Integration test request",
                "PENDING",
                null,
                null
            );

            UUID createdId = UUID.randomUUID();
            ClientRequest savedRequest = new ClientRequest(
                createdId,
                sampleClientId,
                "Integration test request",
                "PENDING",
                java.time.LocalDateTime.now(),
                java.time.LocalDateTime.now()
            );

            when(persistencePort.save(any(ClientRequest.class))).thenReturn(savedRequest);
            when(persistencePort.findById(createdId)).thenReturn(Optional.of(savedRequest));

            ClientRequest created = clientRequestService.createRequest(newRequest);
            Optional<ClientRequest> found = clientRequestService.getRequestById(created.id());
            ClientRequest updated = clientRequestService.updateRequestStatus(created.id(), "COMPLETED");

            assertThat(created.id()).isEqualTo(createdId);
            assertThat(found).isPresent();
            assertThat(found.get().status()).isEqualTo("PENDING");
            assertThat(updated.status()).isEqualTo("COMPLETED");

            verify(persistencePort, times(1)).save(any(ClientRequest.class));
            verify(persistencePort, times(1)).findById(createdId);
            verify(persistencePort, times(2)).save(any(ClientRequest.class));
        }
    }
}