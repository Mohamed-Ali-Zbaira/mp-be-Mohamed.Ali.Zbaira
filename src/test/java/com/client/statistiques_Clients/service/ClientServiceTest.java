package com.client.statistiques_Clients.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.client.statistiques_Clients.entity.Client;
import com.client.statistiques_Clients.entity.Facture;
import com.client.statistiques_Clients.repository.ClientRepository;
import com.client.statistiques_Clients.repository.FactureRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private FactureRepository factureRepository;

    @InjectMocks
    private ClientService clientService;


    @Test
    void testFindActiveClients() {
        // Mocking data
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        Client activeClient = new Client(1L, "ActiveClient", "ActiveAddress", null);
        Facture activeFacture = new Facture(1L, sixMonthsAgo.plusDays(1), activeClient);
        activeClient.setFactures(Arrays.asList(activeFacture));

        // Mocking repository behavior
        when(clientRepository.findByFactures_DateFactureAfter(sixMonthsAgo)).thenReturn(Arrays.asList(activeClient));

        // Testing the method
        List<Client> result = clientService.findActiveClients();
        assertEquals(1, result.size());
        assertEquals(activeClient, result.get(0));
    }


    @Test
    void testGetAllClients() {
        // Mocking data
        Client client1 = new Client(1L, "Client1", "Address1", null);
        Client client2 = new Client(2L, "Client2", "Address2", null);

        // Mocking repository behavior
        when(clientRepository.findAll()).thenReturn(Arrays.asList(client1, client2));

        // Testing the method
        List<Client> result = clientService.getAllClients();
        assertEquals(2, result.size());
        assertTrue(result.contains(client1));
        assertTrue(result.contains(client2));
    }

    @Test
    void testGetClientsByNbFactures() {
        // Mocking data
        Client client1 = new Client(1L, "Client1", "Address1", Arrays.asList(new Facture(1L, LocalDate.now(), null)));
        Client client2 = new Client(2L, "Client2", "Address2", Arrays.asList(new Facture(2L, LocalDate.now(), null),
                new Facture(3L, LocalDate.now(), null)));

        // Mocking repository behavior
        when(clientRepository.findByOrderByFacturesAsc()).thenReturn(Arrays.asList(client1, client2));

        // Testing the method
        List<Client> result = clientService.getClientsByNbFactures();
        assertEquals(2, result.size());
        assertEquals(client1, result.get(0));
        assertEquals(client2, result.get(1));
    }

    @Test
    void testCountActiveClients() {
        // Mocking data
        List<Client> activeClients = Arrays.asList(new Client(1L, "ActiveClient", "ActiveAddress", null),
                new Client(2L, "AnotherActiveClient", "AnotherActiveAddress", null));

        // Mocking method call
        when(clientService.findActiveClients()).thenReturn(activeClients);

        // Testing the method
        long result = clientService.countActiveClients();
        assertEquals(2, result);
    }

    @Test
    void testCountNonActiveClients() {
        // Mocking data
        List<Client> nonActiveClients = Arrays.asList(new Client(1L, "NonActiveClient", "NonActiveAddress", Arrays.asList(new Facture(/*...*/))),
                new Client(2L, "AnotherNonActiveClient", "AnotherNonActiveAddress", Arrays.asList(new Facture(/*... */))));


        // Mocking method call
        when(clientService.findNonActiveClients()).thenReturn(nonActiveClients);

        // Testing the method
        long result = clientService.countNonActiveClients();
        assertEquals(2, result);
    }

    @Test
    void testGetAllClientsCount() {
        // Mocking data
        List<Client> allClients = Arrays.asList(new Client(1L, "Client1", "Address1", null),
                new Client(2L, "Client2", "Address2", null));

        // Mocking method call
        when(clientService.getAllClients()).thenReturn(allClients);

        // Testing the method
        long result = clientService.getAllClientsCount();
        assertEquals(2, result);
    }
}
