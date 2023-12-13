package com.client.statistiques_Clients.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdFacture")
    private Long idFacture;

    @Column(name = "DateFacture")
    private LocalDate dateFacture;

    @JsonIgnore
    @ManyToOne
    private Client client;

    @Column(name = "Total")
    private double total;


    public Facture() {
    }

    public Facture(LocalDate dateFacture, double total) {
        this.dateFacture = dateFacture;
        this.total = total;
    }

    public Facture(long l, LocalDate localDate, Client activeClient) {
    }


    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public LocalDate getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(LocalDate dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
