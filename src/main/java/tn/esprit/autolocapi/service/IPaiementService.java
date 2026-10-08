package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Paiement;
import java.util.List;

public interface IPaiementService {

    Paiement addPaiement(Paiement paiement);

    List<Paiement> getAllPaiements();

    Paiement getPaiementById(Long id);

    void deletePaiement(Long id);
}