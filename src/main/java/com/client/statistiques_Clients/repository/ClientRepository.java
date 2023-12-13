package com.client.statistiques_Clients.repository;

import com.client.statistiques_Clients.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByFactures_DateFactureAfter(LocalDate sixMonthsAgo);
    List<Client> findByOrderByFacturesAsc();
}
