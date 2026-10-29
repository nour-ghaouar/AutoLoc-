package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.web.dto.PaiementDTO;

import java.util.List;

public interface IPaiementService {

    PaiementDTO findById(Long id);

    List<PaiementDTO> findAll();
}