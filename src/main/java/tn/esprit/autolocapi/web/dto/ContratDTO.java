package tn.esprit.autolocapi.web.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ContratDTO(

        Long idContrat,

        @NotNull(message = "La date de signature est obligatoire")
        LocalDate dateSignature,

        @NotNull(message = "Le montant total est obligatoire")
        @DecimalMin(
                value = "0.0",
                inclusive = true,
                message = "Le montant total doit être positif ou nul"
        )
        BigDecimal montantTotal,

        boolean valide,

        Long reservationId

) {
}