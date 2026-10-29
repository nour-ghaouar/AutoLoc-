package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.web.dto.ReservationDTO;

import java.util.List;

public interface IReservationService {

    ReservationDTO create(ReservationDTO dto);

    ReservationDTO findById(Long id);

    List<ReservationDTO> findAll();

    ReservationDTO update(
            Long id,
            ReservationDTO dto
    );

    void deleteById(Long id);
}