package tn.esprit.autolocapi.web.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tn.esprit.autolocapi.domain.CategorieVehicule;
import tn.esprit.autolocapi.domain.StatutVehicule;

import java.math.BigDecimal;

public record VehiculeDTO(

        Long idVehicule,

        @NotBlank(message = "L'immatriculation est obligatoire")
        String immatriculation,

        @NotBlank(message = "La marque est obligatoire")
        String marque,

        @NotBlank(message = "Le modèle est obligatoire")
        String modele,

        @NotNull(message = "La catégorie est obligatoire")
        CategorieVehicule categorie,

        @NotNull(message = "Le tarif journalier est obligatoire")
        @DecimalMin(
                value = "0.0",
                inclusive = true,
                message = "Le tarif journalier doit être positif ou nul"
        )
        BigDecimal tarifJournalier,

        @NotNull(message = "Le statut est obligatoire")
        StatutVehicule statut,

        Long agenceId

) {
}