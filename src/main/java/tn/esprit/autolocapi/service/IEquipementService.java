package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Equipement;
import java.util.List;

public interface IEquipementService {

    Equipement addEquipement(Equipement equipement);

    List<Equipement> getAllEquipements();

    Equipement getEquipementById(Long id);

    void deleteEquipement(Long id);
}