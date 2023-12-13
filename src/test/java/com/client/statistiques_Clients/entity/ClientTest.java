package com.client.statistiques_Clients.entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClientTest {

    @InjectMocks
    private Client client;

    @Mock
    private List<Facture> factures;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetId() {
        client.setId(1L);
        assertEquals(1L, client.getId());
    }

    @Test
    void testGetName() {
        client.setName("John");
        assertEquals("John", client.getName());
    }

    @Test
    void testGetLastname() {
        client.setLastname("Doe");
        assertEquals("Doe", client.getLastname());
    }

    @Test
    void testGetNumero() {
        client.setNumero("12345");
        assertEquals("12345", client.getNumero());
    }


    @Test
    void testGetAdresse() {
        client.setAdresse("123 Main St");
        assertEquals("123 Main St", client.getAdresse());
    }

    @Test
    void testGetDateInscription() {
        LocalDate date = LocalDate.now();
        client.setDateInscription(date);
        assertEquals(date, client.getDateInscription());
    }

    @Test
    void testGetFactures() {
        List<Facture> factures = new ArrayList<>();
        Facture facture1 = new Facture(/* initialize Facture properties */);
        Facture facture2 = new Facture(/* initialize Facture properties */);
        factures.add(facture1);
        factures.add(facture2);

        client.setFactures(factures);

        assertNotNull(client.getFactures());
        assertEquals(2, client.getFactures().size());
    }

    @Test
    void testSetId() {
        client.setId(1L);
        assertEquals(1L, client.getId());
    }

    @Test
    void testSetName() {
        client.setName("John");
        assertEquals("John", client.getName());
    }

    @Test
    void testSetLastname() {
        client.setLastname("Doe");
        assertEquals("Doe", client.getLastname());
    }

    @Test
    void testSetNumero() {
        client.setNumero("12345");
        assertEquals("12345", client.getNumero());
    }

    @Test
    void testSetAdresse() {
        client.setAdresse("123 Main St");
        assertEquals("123 Main St", client.getAdresse());
    }

    @Test
    void testSetDateInscription() {
        LocalDate date = LocalDate.now();
        client.setDateInscription(date);
        assertEquals(date, client.getDateInscription());
    }

    @Test
    void testSetFactures() {
        List<Facture> factures = new ArrayList<>();
        Facture facture1 = new Facture(/* initialize Facture properties */);
        Facture facture2 = new Facture(/* initialize Facture properties */);
        factures.add(facture1);
        factures.add(facture2);

        client.setFactures(factures);

        assertNotNull(client.getFactures());
        assertEquals(2, client.getFactures().size());
    }

}

