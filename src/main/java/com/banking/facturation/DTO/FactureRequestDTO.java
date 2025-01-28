package com.banking.facturation.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
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
