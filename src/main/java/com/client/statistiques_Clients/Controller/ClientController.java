package com.client.statistiques_Clients.Controller;

import com.client.statistiques_Clients.entity.Client;
import com.client.statistiques_Clients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/most-loyal")
    public ResponseEntity<Client> getMostLoyalClient() {
        Optional<Client> mostLoyalClient = clientService.findMostLoyalClient();
        return mostLoyalClient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/non-active-clients")
    public ResponseEntity<List<Client>> getNonActiveClients() {
        List<Client> nonActiveClients = clientService.findNonActiveClients();
        return ResponseEntity.ok(nonActiveClients);
    }

    @GetMapping("/active-clients")
    public ResponseEntity<List<Client>> getActiveClients() {
        List<Client> activeClients = clientService.findActiveClients();
        return activeClients.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(activeClients);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> allClients = clientService.getAllClients();
        return ResponseEntity.ok(allClients);
    }

    @GetMapping("/by-nb-factures")
    public ResponseEntity<List<Client>> getClientsByNbFactures() {
        List<Client> clientsByNbFactures = clientService.getClientsByNbFactures();
        return ResponseEntity.ok(clientsByNbFactures);
    }

    @GetMapping("/client-counts-by-address")
    public ResponseEntity<Map<String, Long>> getClientCountsByAddress() {
        Map<String, Long> clientCountsByAddress = clientService.getClientCountsByAddress();
        return ResponseEntity.ok(clientCountsByAddress);
    }

    @GetMapping("/invoice-counts-ordered-descending")
    public ResponseEntity<Map<String, Long>> getInvoiceCountsByClientOrderedDescending() {
        Map<String, Long> invoiceCountsOrderedDescending = clientService.getInvoiceCountsByClientOrderedDescending();
        return ResponseEntity.ok(invoiceCountsOrderedDescending);
    }

    @GetMapping("/active-clients-count")
    public ResponseEntity<Long> getActiveClientsCount() {
        long activeClientsCount = clientService.countActiveClients();
        return ResponseEntity.ok(activeClientsCount);
    }

    @GetMapping("/non-active-clients-count")
    public ResponseEntity<Long> getNonActiveClientsCount() {
        long nonActiveClientsCount = clientService.countNonActiveClients();
        return ResponseEntity.ok(nonActiveClientsCount);
    }

    @GetMapping("/all-client-count")
    public ResponseEntity<Long> getAllClientsCount() {
        long allClientsCount = clientService.getAllClientsCount();
        return ResponseEntity.ok(allClientsCount);
    }
}
