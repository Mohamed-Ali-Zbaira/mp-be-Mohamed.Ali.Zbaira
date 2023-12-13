package com.client.statistiques_Clients.entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class FactureTest {

    @InjectMocks
    private Facture facture;

    @Mock
    private Client client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetIdFacture() {
        facture.setIdFacture(1L);
        assertEquals(1L, facture.getIdFacture());
    }

    @Test
    void testGetDateFacture() {
        LocalDate date = LocalDate.now();
        facture.setDateFacture(date);
        assertEquals(date, facture.getDateFacture());
    }

    @Test
    void testGetClient() {
        when(client.getName()).thenReturn("John");
        facture.setClient(client);

        assertNotNull(facture.getClient());
        assertEquals("John", facture.getClient().getName());
    }

    @Test
    void testGetTotal() {
        facture.setTotal(100.0);
        assertEquals(100.0, facture.getTotal());
    }

    @Test
    void testSetIdFacture() {
        facture.setIdFacture(1L);
        assertEquals(1L, facture.getIdFacture());
    }

    @Test
    void testSetDateFacture() {
        LocalDate date = LocalDate.now();
        facture.setDateFacture(date);
        assertEquals(date, facture.getDateFacture());
    }

    @Test
    void testSetClient() {
        when(client.getName()).thenReturn("John");
        facture.setClient(client);

        assertNotNull(facture.getClient());
        assertEquals("John", facture.getClient().getName());
    }

    @Test
    void testSetTotal() {
        facture.setTotal(100.0);
        assertEquals(100.0, facture.getTotal());
    }

}
