package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.web.dto.EquipementDTO;

@Component
public class EquipementMapper {

    public Equipement toEntity(EquipementDTO dto) {

        Equipement equipement = new Equipement();
        equipement.setLibelle(dto.libelle());

        return equipement;
    }

    public EquipementDTO toDTO(
            Equipement equipement) {

        return new EquipementDTO(
                equipement.getIdEquipement(),
                equipement.getLibelle()
        );
    }

    public void updateEntity(
            EquipementDTO dto,
            Equipement equipement) {

        equipement.setLibelle(dto.libelle());
    }
}