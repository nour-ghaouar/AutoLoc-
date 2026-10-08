package tn.esprit.autolocapi.service;

import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.repository.IAgenceRepository;

import java.util.List;

@Service
public class AgenceService implements IAgenceService {

    private final IAgenceRepository agenceRepository;

    public AgenceService(IAgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence getAgenceById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Agence introuvable avec id : " + id));
    }

    @Override
    public Agence updateAgence(Long id, Agence agence) {

        Agence existingAgence = getAgenceById(id);

        existingAgence.setNom(agence.getNom());
        existingAgence.setVille(agence.getVille());
        existingAgence.setAdresse(agence.getAdresse());
        existingAgence.setTelephone(agence.getTelephone());

        return agenceRepository.save(existingAgence);
    }

    @Override
    public void deleteAgence(Long id) {
        agenceRepository.deleteById(id);
    }
}