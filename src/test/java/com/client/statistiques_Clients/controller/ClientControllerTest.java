package com.client.statistiques_Clients.controller;

import com.client.statistiques_Clients.Controller.ClientController;
import com.client.statistiques_Clients.entity.Client;
import com.client.statistiques_Clients.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    public void testGetMostLoyalClient() throws Exception {
        // Given
        Client mostLoyalClient = new Client();
        mostLoyalClient.setId(1L);
        mostLoyalClient.setName("Most Loyal");

        Mockito.when(clientService.findMostLoyalClient()).thenReturn(Optional.of(mostLoyalClient));

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/most-loyal")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Most Loyal"));

        // Then
        result.andReturn();
    }

    @Test
    public void testGetMostLoyalClient_NotFound() throws Exception {
        // Given
        Mockito.when(clientService.findMostLoyalClient()).thenReturn(Optional.empty());

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/most-loyal")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        // Then
        result.andReturn();
    }

    @Test
    public void testGetNonActiveClients() throws Exception {
        // Given
        List<Client> nonActiveClients = Collections.singletonList(new Client());
        Mockito.when(clientService.findNonActiveClients()).thenReturn(nonActiveClients);

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/non-active-clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andReturn();
    }

    @Test
    public void testGetActiveClients() throws Exception {
        // Given
        List<Client> activeClients = Collections.singletonList(new Client());
        Mockito.when(clientService.findActiveClients()).thenReturn(activeClients);

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/active-clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andReturn();
    }

    @Test
    public void testGetAllClients() throws Exception {
        // Given
        List<Client> allClients = Collections.singletonList(new Client());
        Mockito.when(clientService.getAllClients()).thenReturn(allClients);

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andReturn();
    }

    @Test
    public void testGetClientsByNbFactures() throws Exception {
        // Given
        List<Client> clientsByNbFactures = Collections.singletonList(new Client());
        Mockito.when(clientService.getClientsByNbFactures()).thenReturn(clientsByNbFactures);

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/by-nb-factures")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andReturn();
    }

    @Test
    public void testGetClientCountsByAddress() throws Exception {
        // Given
        Map<String, Long> clientCountsByAddress = new HashMap<>();
        clientCountsByAddress.put("address", 1L);
        Mockito.when(clientService.getClientCountsByAddress()).thenReturn(clientCountsByAddress);

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/client-counts-by-address")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andReturn();
    }

    @Test
    public void testGetInvoiceCountsByClientOrderedDescending() throws Exception {
        // Given
        Map<String, Long> invoiceCountsOrderedDescending = new HashMap<>();
        invoiceCountsOrderedDescending.put("client", 1L);
        Mockito.when(clientService.getInvoiceCountsByClientOrderedDescending()).thenReturn(invoiceCountsOrderedDescending);

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/invoice-counts-ordered-descending")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andReturn();
    }

    @Test
    public void testGetActiveClientsCount() throws Exception {
        // Given
        long activeClientsCount = 5L;
        Mockito.when(clientService.countActiveClients()).thenReturn(activeClientsCount);

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/active-clients-count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andReturn();
    }

    @Test
    public void testGetNonActiveClientsCount() throws Exception {
        // Given
        long nonActiveClientsCount = 3L;
        Mockito.when(clientService.countNonActiveClients()).thenReturn(nonActiveClientsCount);

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/non-active-clients-count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andReturn();
    }

    @Test
    public void testGetAllClientsCount() throws Exception {
        // Given
        long allClientsCount = 8L;
        Mockito.when(clientService.getAllClientsCount()).thenReturn(allClientsCount);

        // When
        ResultActions result = mockMvc.perform(get("/api/clients/all-client-count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andReturn();
    }
}
