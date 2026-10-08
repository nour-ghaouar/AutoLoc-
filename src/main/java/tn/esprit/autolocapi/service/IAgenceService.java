package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Agence;

import java.util.List;

public interface IAgenceService {

    Agence addAgence(Agence agence);

    List<Agence> getAllAgences();

    Agence getAgenceById(Long id);

    Agence updateAgence(Long id, Agence agence);

    void deleteAgence(Long id);
}