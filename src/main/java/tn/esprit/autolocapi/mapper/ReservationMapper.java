package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.web.dto.ReservationDTO;

@Component
public class ReservationMapper {

    public Reservation toEntity(
            ReservationDTO dto) {

        Reservation reservation =
                new Reservation();

        reservation.setDateDebut(dto.dateDebut());
        reservation.setDateFin(dto.dateFin());
        reservation.setStatut(dto.statut());

        return reservation;
    }

    public ReservationDTO toDTO(
            Reservation reservation) {

        Long clientId =
                reservation.getClient() != null
                        ? reservation.getClient().getIdClient()
                        : null;

        Long vehiculeId =
                reservation.getVehicule() != null
                        ? reservation.getVehicule().getIdVehicule()
                        : null;

        Long contratId =
                reservation.getContrat() != null
                        ? reservation.getContrat().getIdContrat()
                        : null;

        return new ReservationDTO(
                reservation.getIdReservation(),
                reservation.getDateDebut(),
                reservation.getDateFin(),
                reservation.getStatut(),
                clientId,
                vehiculeId,
                contratId
        );
    }

    public void updateEntity(
            ReservationDTO dto,
            Reservation reservation) {

        reservation.setDateDebut(dto.dateDebut());
        reservation.setDateFin(dto.dateFin());
        reservation.setStatut(dto.statut());
    }
}