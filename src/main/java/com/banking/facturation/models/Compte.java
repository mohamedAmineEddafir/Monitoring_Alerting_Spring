package com.banking.facturation.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;


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

    // getter && setter

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    // hashCode && equals

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return idCompte == compte.idCompte && Objects.equals(solde, compte.solde) && Objects.equals(dateCreation, compte.dateCreation) && Objects.equals(client, compte.client) && Objects.equals(factures, compte.factures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompte, solde, dateCreation, client, factures);
    }

    @Override
    public String toString() {
        return "Compte{" +
                "idCompte=" + idCompte +
                ", solde=" + solde +
                ", dateCreation=" + dateCreation +
                ", client=" + client +
                ", factures=" + factures +
                '}';
    }
}
