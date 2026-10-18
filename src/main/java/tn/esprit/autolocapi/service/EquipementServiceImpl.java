package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.repository.IEquipementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipementRepository equipementRepository;

    @Override
    public Equipement create(Equipement equipement) {

        if (equipement.getIdEquipement() != null) {
            throw new IllegalArgumentException(
                    "Un nouvel équipement ne doit pas avoir d'identifiant"
            );
        }

        validateEquipement(equipement);

        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement findById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Equipement", id));
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement update(Long id, Equipement equipement) {

        Equipement existing = findById(id);

        validateEquipement(equipement);

        existing.setLibelle(equipement.getLibelle());

        return equipementRepository.save(existing);
    }

    @Override
    public void deleteById(Long id) {

        if (!equipementRepository.existsById(id)) {
            throw new ResourceNotFoundException("Equipement", id);
        }

        equipementRepository.deleteById(id);
    }

    private void validateEquipement(Equipement equipement) {

        if (equipement.getLibelle() == null
                || equipement.getLibelle().isBlank()) {

            throw new IllegalArgumentException(
                    "Le libellé de l'équipement est obligatoire"
            );
        }
    }
}