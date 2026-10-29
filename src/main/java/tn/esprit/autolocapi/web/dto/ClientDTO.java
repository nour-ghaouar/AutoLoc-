package tn.esprit.autolocapi.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ClientDTO(

        Long idClient,

        @NotBlank(message = "Le nom est obligatoire")
        String nom,

        @NotBlank(message = "Le prénom est obligatoire")
        String prenom,

        @NotBlank(message = "L'email est obligatoire")
        @Email(message = "L'adresse email est invalide")
        String email,

        @NotBlank(message = "Le téléphone est obligatoire")
        String telephone,

        @NotBlank(message = "Le numéro de permis est obligatoire")
        String numPermis,

        @NotNull(message = "La date d'inscription est obligatoire")
        @PastOrPresent(
                message = "La date d'inscription ne peut pas être future"
        )
        LocalDate dateInscription

) {
}