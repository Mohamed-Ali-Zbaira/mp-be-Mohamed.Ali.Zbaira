package com.client.statistiques_Clients.repository;

import com.client.statistiques_Clients.entity.Client;
import com.client.statistiques_Clients.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    Long countByClient(Client client);
}
