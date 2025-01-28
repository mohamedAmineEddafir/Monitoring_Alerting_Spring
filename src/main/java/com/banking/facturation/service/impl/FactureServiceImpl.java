package com.banking.facturation.service.impl;

import com.banking.facturation.models.Client;
import com.banking.facturation.models.Compte;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;
import com.banking.facturation.repository.ClientRepo;
import com.banking.facturation.repository.CompteRepo;
import com.banking.facturation.repository.FactureRepo;
import com.banking.facturation.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FactureServiceImpl implements FactureService {
    private final ClientRepo clientRepo;
    private final CompteRepo compteRepo;

    @Autowired
    public FactureServiceImpl (ClientRepo clientRepo, CompteRepo compteRepo, FactureRepo factureRepo) {
        this.clientRepo = clientRepo;
        this.compteRepo = compteRepo;
    }

    @Override
    public byte[] generateFacture(String email, Integer numeroCompte){
        try {
            // Validation des donnees
            Client client = clientRepo.findByEmail(email)
                    .orElseThrow(()-> new RuntimeException("Verify your Email :  " + email));
            Compte compte = compteRepo.findById(numeroCompte)
                    .orElseThrow(()-> new RuntimeException("Verify your Account Identity number :  " + numeroCompte));

            // Verification que le compte appartient au client
            if (compte.getClient().getIdClient() != client.getIdClient()) {
                throw new RuntimeException("Verify your Account Identity number :  " + compte.getClient().getIdClient());
            }

            // Creation de PDF
            Document document = new Document();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, outputStream);

            document.open();

            // Header Document
            document.add(new Paragraph("Facture"));
            document.add(new Paragraph("--------------------------------------"));

            // Date actuelle
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            document.add(new Paragraph("Generate At :  "+localDateTime.format(formatter)));
            document.add(new Paragraph(" "));

            // Information Client
            document.add(new Paragraph("Information's Client: "));
            document.add(new Paragraph("  Nom : " + client.getNom()));
            document.add(new Paragraph("  Prenom : "+ client.getPrenom()));
            document.add(new Paragraph("  Email : " + client.getEmail()));
            document.add(new Paragraph("  Account Number : " + compte.getIdCompte()));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Solde :"+ compte.getSolde()));

            document.close();
            return outputStream.toByteArray();

        } catch (DocumentException e){
            throw new RuntimeException("Erreur lors de la generation du PDF", e);
        }
    }
}
