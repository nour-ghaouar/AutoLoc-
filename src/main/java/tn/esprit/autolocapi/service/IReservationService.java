package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Reservation;
import java.util.List;

public interface IReservationService {

    Reservation addReservation(Reservation reservation);

    List<Reservation> getAllReservations();

    Reservation getReservationById(Long id);

    void deleteReservation(Long id);
}