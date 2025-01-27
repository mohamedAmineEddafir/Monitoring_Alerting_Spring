package com.banking.facturation.repository;

import com.banking.facturation.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepo extends JpaRepository<Facture, Integer> {
}
