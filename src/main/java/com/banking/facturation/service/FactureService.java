package com.banking.facturation.service;

public interface FactureService {
    byte[] generateFacture(String email, Integer numeroCompte);
}
