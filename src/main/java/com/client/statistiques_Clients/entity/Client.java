package com.client.statistiques_Clients.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Lastname")
    private String lastname;

    @Column(name = "Numero")
    private String numero;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Date_Inscription")
    private LocalDate dateInscription;
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Facture> factures;


    public Client() {

    }

    public Client(String name, String lastname, String numero, String adresse, LocalDate dateInscription) {
        this.name = name;
        this.lastname = lastname;
        this.numero = numero;
        this.adresse = adresse;
        this.dateInscription = dateInscription;
    }

    public Client(long l, String inactiveClient, String inactiveAddress, Object o) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }

    public List<Facture> getFactures() {
        if (factures == null) {
            factures = new ArrayList<>();
        }
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }
}
