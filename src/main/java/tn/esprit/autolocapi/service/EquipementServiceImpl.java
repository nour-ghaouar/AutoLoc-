package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.EquipementMapper;
import tn.esprit.autolocapi.repository.IEquipementRepository;
import tn.esprit.autolocapi.web.dto.EquipementDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl
        implements IEquipementService {

    private final IEquipementRepository equipementRepository;
    private final EquipementMapper equipementMapper;

    @Override
    public EquipementDTO create(
            EquipementDTO dto) {

        if (dto.idEquipement() != null) {
            throw new IllegalArgumentException(
                    "Un nouvel équipement ne doit pas avoir d'identifiant"
            );
        }

        Equipement equipement =
                equipementMapper.toEntity(dto);

        equipement =
                equipementRepository.save(equipement);

        return equipementMapper.toDTO(equipement);
    }

    @Override
    public EquipementDTO findById(Long id) {

        return equipementMapper.toDTO(
                getEquipement(id)
        );
    }

    @Override
    public List<EquipementDTO> findAll() {

        return equipementRepository
                .findAll()
                .stream()
                .map(equipementMapper::toDTO)
                .toList();
    }

    @Override
    public EquipementDTO update(
            Long id,
            EquipementDTO dto) {

        Equipement equipement =
                getEquipement(id);

        equipementMapper.updateEntity(
                dto,
                equipement
        );

        equipement =
                equipementRepository.save(equipement);

        return equipementMapper.toDTO(equipement);
    }

    @Override
    public void deleteById(Long id) {

        if (!equipementRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Equipement",
                    id
            );
        }

        equipementRepository.deleteById(id);
    }

    private Equipement getEquipement(Long id) {

        return equipementRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Equipement",
                                id
                        ));
    }
}