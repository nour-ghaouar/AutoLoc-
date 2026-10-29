package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.VehiculeMapper;
import tn.esprit.autolocapi.repository.IAgenceRepository;
import tn.esprit.autolocapi.repository.IVehiculeRepository;
import tn.esprit.autolocapi.web.dto.VehiculeDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl
        implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final IAgenceRepository agenceRepository;
    private final VehiculeMapper vehiculeMapper;

    @Override
    public VehiculeDTO create(
            VehiculeDTO dto) {

        if (dto.idVehicule() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau véhicule ne doit pas avoir d'identifiant"
            );
        }

        Vehicule vehicule =
                vehiculeMapper.toEntity(dto);

        if (dto.agenceId() != null) {
            vehicule.setAgence(
                    getAgence(dto.agenceId())
            );
        }

        vehicule =
                vehiculeRepository.save(vehicule);

        return vehiculeMapper.toDTO(vehicule);
    }

    @Override
    public VehiculeDTO findById(Long id) {

        return vehiculeMapper.toDTO(
                getVehicule(id)
        );
    }

    @Override
    public List<VehiculeDTO> findAll() {

        return vehiculeRepository
                .findAll()
                .stream()
                .map(vehiculeMapper::toDTO)
                .toList();
    }

    @Override
    public VehiculeDTO update(
            Long id,
            VehiculeDTO dto) {

        Vehicule vehicule =
                getVehicule(id);

        vehiculeMapper.updateEntity(
                dto,
                vehicule
        );

        if (dto.agenceId() != null) {
            vehicule.setAgence(
                    getAgence(dto.agenceId())
            );
        } else {
            vehicule.setAgence(null);
        }

        vehicule =
                vehiculeRepository.save(vehicule);

        return vehiculeMapper.toDTO(vehicule);
    }

    @Override
    public void deleteById(Long id) {

        if (!vehiculeRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Vehicule",
                    id
            );
        }

        vehiculeRepository.deleteById(id);
    }

    private Vehicule getVehicule(Long id) {

        return vehiculeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vehicule",
                                id
                        ));
    }

    private Agence getAgence(Long id) {

        return agenceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Agence",
                                id
                        ));
    }
}