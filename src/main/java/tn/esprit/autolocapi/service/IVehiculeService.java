package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.web.dto.VehiculeDTO;

import java.util.List;

public interface IVehiculeService {

    VehiculeDTO create(VehiculeDTO dto);

    VehiculeDTO findById(Long id);

    List<VehiculeDTO> findAll();

    VehiculeDTO update(Long id, VehiculeDTO dto);

    void deleteById(Long id);
}