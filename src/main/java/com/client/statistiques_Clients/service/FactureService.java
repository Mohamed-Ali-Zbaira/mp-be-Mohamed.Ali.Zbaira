package com.client.statistiques_Clients.service;

import com.client.statistiques_Clients.entity.Client;
import com.client.statistiques_Clients.entity.Facture;
import com.client.statistiques_Clients.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {
    private final FactureRepository factureRepository;

    @Autowired
    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public Optional<Facture> getFactureById(Long id) {
        return factureRepository.findById(id);
    }

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }
}
