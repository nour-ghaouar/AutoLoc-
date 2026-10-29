package tn.esprit.autolocapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AgenceDTO(

        Long idAgence,

        @NotBlank(message = "Le nom de l'agence est obligatoire")
        String nom,

        @NotBlank(message = "La ville est obligatoire")
        String ville,

        @NotBlank(message = "L'adresse est obligatoire")
        String adresse,

        @NotBlank(message = "Le téléphone est obligatoire")
        @Pattern(
                regexp = "^[0-9+ ]{8,15}$",
                message = "Le numéro de téléphone est invalide"
        )
        String telephone

) {
}