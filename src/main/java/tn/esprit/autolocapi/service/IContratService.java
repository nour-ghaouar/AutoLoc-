package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Contrat;
import java.util.List;

public interface IContratService {

    Contrat addContrat(Contrat contrat);

    List<Contrat> getAllContrats();

    Contrat getContratById(Long id);

    void deleteContrat(Long id);
}