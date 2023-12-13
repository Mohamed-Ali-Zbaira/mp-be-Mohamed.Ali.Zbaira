package com.client.statistiques_Clients.service;

import com.client.statistiques_Clients.entity.Facture;
import com.client.statistiques_Clients.repository.FactureRepository;
import com.client.statistiques_Clients.service.FactureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FactureServiceTest {

    @Mock
    private FactureRepository factureRepository;

    @InjectMocks
    private FactureService factureService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFactureById() {
        // Given
        Long factureId = 1L;
        Facture facture = new Facture(LocalDate.now(), 100.0);
        facture.setIdFacture(factureId);

        // Mockito setup
        when(factureRepository.findById(factureId)).thenReturn(Optional.of(facture));

        // When
        Optional<Facture> result = factureService.getFactureById(factureId);

        // Then
        assertEquals(Optional.of(facture), result);
        verify(factureRepository, times(1)).findById(factureId);
    }

    @Test
    public void testGetAllFactures() {
        // Given
        Facture facture1 = new Facture(LocalDate.now(), 100.0);
        Facture facture2 = new Facture(LocalDate.now(), 200.0);
        List<Facture> factureList = Arrays.asList(facture1, facture2);

        // Mockito setup
        when(factureRepository.findAll()).thenReturn(factureList);

        // When
        List<Facture> result = factureService.getAllFactures();

        // Then
        assertEquals(factureList, result);
        verify(factureRepository, times(1)).findAll();
    }

}
