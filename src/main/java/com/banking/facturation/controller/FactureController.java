package com.banking.facturation.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.banking.facturation.DTO.FactureRequestDTO;
import com.banking.facturation.service.FactureService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api/facture")
public class FactureController {

    private final FactureService factureService;

    @Autowired
    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @PostMapping("/generer")
    public ResponseEntity<byte[]> genererFacture(@Valid @RequestBody FactureRequestDTO request) {
        byte[] pdf = factureService.generateFacture(
                request.getEmail(),
                request.getNumeroCompte()
        );
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header("Content-Type", "application/pdf")
                .header("Content-Disposition", "attachment; filename=facture.pdf")
                .body(pdf);
    }
}
