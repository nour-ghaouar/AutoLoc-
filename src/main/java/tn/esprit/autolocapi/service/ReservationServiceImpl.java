package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Client;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.domain.Vehicule;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.ReservationMapper;
import tn.esprit.autolocapi.repository.IClientRepository;
import tn.esprit.autolocapi.repository.IReservationRepository;
import tn.esprit.autolocapi.repository.IVehiculeRepository;
import tn.esprit.autolocapi.web.dto.ReservationDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl
        implements IReservationService {

    private final IReservationRepository reservationRepository;
    private final IClientRepository clientRepository;
    private final IVehiculeRepository vehiculeRepository;
    private final ReservationMapper reservationMapper;

    @Override
    public ReservationDTO create(
            ReservationDTO dto) {

        if (dto.idReservation() != null) {
            throw new IllegalArgumentException(
                    "Une nouvelle réservation ne doit pas avoir d'identifiant"
            );
        }

        validateDates(dto);

        Reservation reservation =
                reservationMapper.toEntity(dto);

        reservation.setClient(
                getClient(dto.clientId())
        );

        reservation.setVehicule(
                getVehicule(dto.vehiculeId())
        );

        reservation =
                reservationRepository.save(reservation);

        return reservationMapper.toDTO(
                reservation
        );
    }

    @Override
    public ReservationDTO findById(Long id) {

        return reservationMapper.toDTO(
                getReservation(id)
        );
    }

    @Override
    public List<ReservationDTO> findAll() {

        return reservationRepository
                .findAll()
                .stream()
                .map(reservationMapper::toDTO)
                .toList();
    }

    @Override
    public ReservationDTO update(
            Long id,
            ReservationDTO dto) {

        validateDates(dto);

        Reservation reservation =
                getReservation(id);

        reservationMapper.updateEntity(
                dto,
                reservation
        );

        reservation.setClient(
                getClient(dto.clientId())
        );

        reservation.setVehicule(
                getVehicule(dto.vehiculeId())
        );

        reservation =
                reservationRepository.save(reservation);

        return reservationMapper.toDTO(
                reservation
        );
    }

    @Override
    public void deleteById(Long id) {

        if (!reservationRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Reservation",
                    id
            );
        }

        reservationRepository.deleteById(id);
    }

    private void validateDates(
            ReservationDTO dto) {

        if (dto.dateFin()
                .isBefore(dto.dateDebut())) {

            throw new IllegalArgumentException(
                    "La date de fin ne peut pas être antérieure à la date de début"
            );
        }
    }

    private Reservation getReservation(Long id) {

        return reservationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reservation",
                                id
                        ));
    }

    private Client getClient(Long id) {

        return clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Client",
                                id
                        ));
    }

    private Vehicule getVehicule(Long id) {

        return vehiculeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Vehicule",
                                id
                        ));
    }
}