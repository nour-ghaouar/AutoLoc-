package tn.esprit.autolocapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.service.IReservationService;
import tn.esprit.autolocapi.web.dto.ReservationDTO;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
@Tag(name = "Reservations")
public class ReservationController {

    private final IReservationService reservationService;

    @Operation(summary = "Lister les réservations")
    @GetMapping
    public List<ReservationDTO> findAll() {
        return reservationService.findAll();
    }

    @Operation(summary = "Consulter une réservation")
    @GetMapping("/{id}")
    public ReservationDTO findById(
            @PathVariable Long id) {

        return reservationService.findById(id);
    }

    @Operation(summary = "Créer une réservation")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDTO create(
            @Valid
            @RequestBody ReservationDTO dto) {

        return reservationService.create(dto);
    }

    @Operation(summary = "Modifier une réservation")
    @PutMapping("/{id}")
    public ReservationDTO update(
            @PathVariable Long id,
            @Valid
            @RequestBody ReservationDTO dto) {

        return reservationService.update(id, dto);
    }

    @Operation(summary = "Supprimer une réservation")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @PathVariable Long id) {

        reservationService.deleteById(id);
    }
}