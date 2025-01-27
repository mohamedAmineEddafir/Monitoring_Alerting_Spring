package com.banking.facturation.repository;

import com.banking.facturation.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte, Integer> {
}
