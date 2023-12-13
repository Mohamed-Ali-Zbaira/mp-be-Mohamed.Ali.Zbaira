package com.client.statistiques_Clients.service;

import com.client.statistiques_Clients.entity.Client;
import com.client.statistiques_Clients.entity.Facture;
import com.client.statistiques_Clients.repository.ClientRepository;
import com.client.statistiques_Clients.repository.FactureRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final FactureRepository factureRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, FactureRepository factureRepository) {
        this.clientRepository = clientRepository;
        this.factureRepository = factureRepository;
    }

    public Optional<Client> findMostLoyalClient() {
        List<Client> clients = clientRepository.findAll();
        Map<Long, Long> clientInvoiceCounts = clients.stream()
                .collect(Collectors.toMap(Client::getId, client -> (long) factureRepository.countByClient(client)));

        return clientInvoiceCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> clientRepository.findById(entry.getKey()))
                .orElse(Optional.empty());
    }

    private String extractGovernmentFromAddress(Client client) {
        return "Government";
    }


    public List<Client> findActiveClients() {
        LocalDate sixMonthsAgo = LocalDate.now().minus(6, ChronoUnit.MONTHS);
        return clientRepository.findByFactures_DateFactureAfter(sixMonthsAgo);
    }

    public List<Client> findNonActiveClients() {
        LocalDate sixMonthsAgo = LocalDate.now().minus(6, ChronoUnit.MONTHS);

        List<Client> nonActiveClients = clientRepository.findAll().stream()
                .filter(client -> client.getFactures().stream()
                        .noneMatch(facture -> {
                            LocalDate dateFacture = facture.getDateFacture();
                            return dateFacture != null && dateFacture.isAfter(sixMonthsAgo);
                        }))
                .collect(Collectors.toList());

        return nonActiveClients;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public List<Client> getClientsByNbFactures() {
        return clientRepository.findByOrderByFacturesAsc();
    }

    public Map<String, Long> getClientCountsByAddress() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream()
                .collect(Collectors.groupingBy(
                        client -> Optional.ofNullable(client.getAdresse()).orElse("Unknown"),
                        Collectors.counting()
                ));
    }

    public Map<String, Long> getInvoiceCountsByClientOrderedDescending() {
        List<Client> clients = clientRepository.findAll();

        return clients.stream()
                .filter(client -> client.getName() != null) // Filter out clients with null names
                .collect(Collectors.toMap(
                        Client::getName,
                        client -> (long) Optional.ofNullable(client.getFactures()).orElse(Collections.emptyList()).size()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public long countActiveClients() {
        List<Client> activeClients = findActiveClients();
        return activeClients.size();
    }

    public long countNonActiveClients() {
        List<Client> nonActiveClients = findNonActiveClients();
        return nonActiveClients.size();
    }

    public long getAllClientsCount() {
        List<Client> allClients = getAllClients();
        return allClients.size();
    }

}
