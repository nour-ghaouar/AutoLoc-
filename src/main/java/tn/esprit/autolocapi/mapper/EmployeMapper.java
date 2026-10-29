package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.web.dto.EmployeDTO;

@Component
public class EmployeMapper {

    public Employe toEntity(EmployeDTO dto) {

        Employe employe = new Employe();

        employe.setNom(dto.nom());
        employe.setPrenom(dto.prenom());
        employe.setRole(dto.role());

        return employe;
    }

    public EmployeDTO toDTO(Employe employe) {

        Long agenceId = employe.getAgence() != null
                ? employe.getAgence().getIdAgence()
                : null;

        return new EmployeDTO(
                employe.getIdEmploye(),
                employe.getNom(),
                employe.getPrenom(),
                employe.getRole(),
                agenceId
        );
    }

    public void updateEntity(
            EmployeDTO dto,
            Employe employe) {

        employe.setNom(dto.nom());
        employe.setPrenom(dto.prenom());
        employe.setRole(dto.role());
    }
}