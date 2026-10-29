package tn.esprit.autolocapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.service.IVehiculeService;
import tn.esprit.autolocapi.web.dto.VehiculeDTO;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
@Tag(name = "Vehicules")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Lister les véhicules")
    @GetMapping
    public List<VehiculeDTO> findAll() {
        return vehiculeService.findAll();
    }

    @Operation(summary = "Consulter un véhicule")
    @GetMapping("/{id}")
    public VehiculeDTO findById(
            @PathVariable Long id) {

        return vehiculeService.findById(id);
    }

    @Operation(summary = "Créer un véhicule")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehiculeDTO create(
            @Valid
            @RequestBody VehiculeDTO dto) {

        return vehiculeService.create(dto);
    }

    @Operation(summary = "Modifier un véhicule")
    @PutMapping("/{id}")
    public VehiculeDTO update(
            @PathVariable Long id,
            @Valid
            @RequestBody VehiculeDTO dto) {

        return vehiculeService.update(id, dto);
    }

    @Operation(summary = "Supprimer un véhicule")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @PathVariable Long id) {

        vehiculeService.deleteById(id);
    }
}