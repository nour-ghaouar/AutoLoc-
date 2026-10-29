package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Maintenance;
import tn.esprit.autolocapi.web.dto.MaintenanceDTO;

@Component
public class MaintenanceMapper {

    public Maintenance toEntity(
            MaintenanceDTO dto) {

        Maintenance maintenance =
                new Maintenance();

        maintenance.setDateDebut(dto.dateDebut());
        maintenance.setDateFin(dto.dateFin());
        maintenance.setDescription(dto.description());

        return maintenance;
    }

    public MaintenanceDTO toDTO(
            Maintenance maintenance) {

        Long vehiculeId =
                maintenance.getVehicule() != null
                        ? maintenance.getVehicule().getIdVehicule()
                        : null;

        return new MaintenanceDTO(
                maintenance.getIdMaintenance(),
                maintenance.getDateDebut(),
                maintenance.getDateFin(),
                maintenance.getDescription(),
                vehiculeId
        );
    }

    public void updateEntity(
            MaintenanceDTO dto,
            Maintenance maintenance) {

        maintenance.setDateDebut(dto.dateDebut());
        maintenance.setDateFin(dto.dateFin());
        maintenance.setDescription(dto.description());
    }
}