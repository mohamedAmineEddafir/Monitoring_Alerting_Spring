package com.banking.facturation.DTO;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor // Constructor with All parameter
@NoArgsConstructor // Constructor without parameter
public class FactureRequestDTO {
    private String email;
    private Integer numeroCompte;

    // Getters
    public String getEmail() {
        return email;
    }

    public Integer getNumeroCompte() {
        return numeroCompte;
    }

}
