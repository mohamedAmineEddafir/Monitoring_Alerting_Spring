package com.banking.facturation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor

public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idClient;

    @NotBlank
    @Column(name = "nom")
    private String nom;

    @NotBlank
    @Column(name = "prenom")
    private String prenom;

    @Email
    @NotBlank
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "telephone")
    private String telephone;

    // Getter's
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getEmail(){
        return email;
    }
    public String getTelephone(){
        return telephone;
    }

    /*
     * Relationships Between Entity's
     */

    // Client to Comte
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Compte compte;

    // Compte to Facture
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Facture> factures;


}
