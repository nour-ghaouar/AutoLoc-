package tn.esprit.autolocapi.service;

import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.repository.IContratRepository;

import java.util.List;

@Service
public class ContratService implements IContratService {

    private final IContratRepository contratRepository;

    public ContratService(IContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Contrat introuvable avec id : " + id));
    }

    @Override
    public void deleteContrat(Long id) {
        contratRepository.deleteById(id);
    }
}