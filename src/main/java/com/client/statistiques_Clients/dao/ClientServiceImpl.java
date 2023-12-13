package com.client.statistiques_Clients.dao;

import com.client.statistiques_Clients.entity.Client;
import com.client.statistiques_Clients.entity.Facture;
import com.client.statistiques_Clients.repository.ClientRepository;
import com.client.statistiques_Clients.repository.FactureRepository;
import com.client.statistiques_Clients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl extends ClientService {
    private final ClientRepository clientRepository;
    private final FactureRepository factureRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, FactureRepository factureRepository) {
        super(clientRepository, factureRepository);
        this.clientRepository = clientRepository;
        this.factureRepository = factureRepository;
    }
}