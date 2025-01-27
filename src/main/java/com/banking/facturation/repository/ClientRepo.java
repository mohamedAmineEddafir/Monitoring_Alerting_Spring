package com.banking.facturation.repository;

import com.banking.facturation.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Integer> {

    Optional<Client> findByEmail(String email);
    Boolean existsByEmail(String email);
}
