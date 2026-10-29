package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.web.dto.AgenceDTO;

@Component
public class AgenceMapper {

    public Agence toEntity(AgenceDTO dto) {
        Agence agence = new Agence();
        updateEntity(dto, agence);
        return agence;
    }

    public AgenceDTO toDTO(Agence agence) {
        return new AgenceDTO(
                agence.getIdAgence(),
                agence.getNom(),
                agence.getVille(),
                agence.getAdresse(),
                agence.getTelephone()
        );
    }

    public void updateEntity(
            AgenceDTO dto,
            Agence agence) {

        agence.setNom(dto.nom());
        agence.setVille(dto.ville());
        agence.setAdresse(dto.adresse());
        agence.setTelephone(dto.telephone());
    }
}