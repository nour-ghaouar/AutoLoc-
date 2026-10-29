package tn.esprit.autolocapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tn.esprit.autolocapi.domain.RoleEmploye;

public record EmployeDTO(

        Long idEmploye,

        @NotBlank(message = "Le nom est obligatoire")
        String nom,

        @NotBlank(message = "Le prénom est obligatoire")
        String prenom,

        @NotNull(message = "Le rôle est obligatoire")
        RoleEmploye role,

        @NotNull(message = "L'agence est obligatoire")
        Long agenceId

) {
}