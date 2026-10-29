package tn.esprit.autolocapi.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MaintenanceDTO(

        Long idMaintenance,

        @NotNull(message = "La date de début est obligatoire")
        LocalDate dateDebut,

        @NotNull(message = "La date de fin est obligatoire")
        LocalDate dateFin,

        @NotBlank(message = "La description est obligatoire")
        String description,

        @NotNull(message = "Le véhicule est obligatoire")
        Long vehiculeId

) {
}