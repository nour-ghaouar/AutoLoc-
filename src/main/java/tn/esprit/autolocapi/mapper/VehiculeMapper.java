package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.web.dto.VehiculeDTO;

@Component
public class VehiculeMapper {

    public Vehicule toEntity(VehiculeDTO dto) {

        Vehicule vehicule = new Vehicule();

        vehicule.setImmatriculation(dto.immatriculation());
        vehicule.setMarque(dto.marque());
        vehicule.setModele(dto.modele());
        vehicule.setCategorie(dto.categorie());
        vehicule.setTarifJournalier(dto.tarifJournalier());
        vehicule.setStatut(dto.statut());

        return vehicule;
    }

    public VehiculeDTO toDTO(Vehicule vehicule) {

        Long agenceId = vehicule.getAgence() != null
                ? vehicule.getAgence().getIdAgence()
                : null;

        return new VehiculeDTO(
                vehicule.getIdVehicule(),
                vehicule.getImmatriculation(),
                vehicule.getMarque(),
                vehicule.getModele(),
                vehicule.getCategorie(),
                vehicule.getTarifJournalier(),
                vehicule.getStatut(),
                agenceId
        );
    }

    public void updateEntity(
            VehiculeDTO dto,
            Vehicule vehicule) {

        vehicule.setImmatriculation(dto.immatriculation());
        vehicule.setMarque(dto.marque());
        vehicule.setModele(dto.modele());
        vehicule.setCategorie(dto.categorie());
        vehicule.setTarifJournalier(dto.tarifJournalier());
        vehicule.setStatut(dto.statut());
    }
}