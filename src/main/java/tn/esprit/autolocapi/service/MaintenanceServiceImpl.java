package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Maintenance;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.MaintenanceMapper;
import tn.esprit.autolocapi.repository.IMaintenanceRepository;
import tn.esprit.autolocapi.repository.IVehiculeRepository;
import tn.esprit.autolocapi.web.dto.MaintenanceDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl
        implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;
    private final IVehiculeRepository vehiculeRepository;
    private final MaintenanceMapper maintenanceMapper;

    @Override
    public MaintenanceDTO create(
            MaintenanceDTO dto) {

        if (dto.idMaintenance() != null) {
            throw new IllegalArgumentException(
                    "Une nouvelle maintenance ne doit pas avoir d'identifiant"
            );
        }

        validateDates(dto);

        Maintenance maintenance =
                maintenanceMapper.toEntity(dto);

        maintenance.setVehicule(
                getVehicule(dto.vehiculeId())
        );

        maintenance =
                maintenanceRepository.save(
                        maintenance
                );

        return maintenanceMapper.toDTO(
                maintenance
        );
    }

    @Override
    public MaintenanceDTO findById(Long id) {

        return maintenanceMapper.toDTO(
                getMaintenance(id)
        );
    }

    @Override
    public List<MaintenanceDTO> findAll() {

        return maintenanceRepository
                .findAll()
                .stream()
                .map(maintenanceMapper::toDTO)
                .toList();
    }

    @Override
    public MaintenanceDTO update(
            Long id,
            MaintenanceDTO dto) {

        validateDates(dto);

        Maintenance maintenance =
                getMaintenance(id);

        maintenanceMapper.updateEntity(
                dto,
                maintenance
        );

        maintenance.setVehicule(
                getVehicule(dto.vehiculeId())
        );

        maintenance =
                maintenanceRepository.save(
                        maintenance
                );

        return maintenanceMapper.toDTO(
                maintenance
        );
    }

    @Override
    public void deleteById(Long id) {

        if (!maintenanceRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Maintenance",
                    id
            );
        }

        maintenanceRepository.deleteById(id);
    }

    private void validateDates(
            MaintenanceDTO dto) {

        if (dto.dateFin()
                .isBefore(dto.dateDebut())) {

            throw new IllegalArgumentException(
                    "La date de fin ne peut pas être antérieure à la date de début"
            );
        }
    }

    private Maintenance getMaintenance(Long id) {

        return maintenanceRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Maintenance",
                                id
                        ));
    }

    private Vehicule getVehicule(Long id) {

        return vehiculeRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vehicule",
                                id
                        ));
    }
}