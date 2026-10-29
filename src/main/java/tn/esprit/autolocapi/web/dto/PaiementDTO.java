package tn.esprit.autolocapi.web.dto;

import tn.esprit.autolocapi.domain.ModePaiement;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaiementDTO(

        Long idPaiement,
        BigDecimal montant,
        LocalDate datePaiement,
        ModePaiement modePaiement,
        Long contratId

) {
}