package com.banking.facturation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "compte")
@NoArgsConstructor
@AllArgsConstructor
public class Compte implements Serializable {
    // private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compte")
    private int idCompte;

    @NotBlank
    @Column(precision = 10, scale = 2)
    private BigDecimal solde;

    @NotBlank
    @Column(name = "date_creation")
    private LocalDate dateCreation;

    // Relation with Client
    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;

    // Relation with Facture Entity
    @OneToMany(mappedBy = "compte",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Facture> factures;

}
