package tn.esprit.autolocapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.service.IMaintenanceService;
import tn.esprit.autolocapi.web.dto.MaintenanceDTO;

import java.util.List;

@RestController
@RequestMapping("/maintenances")
@RequiredArgsConstructor
@Tag(name = "Maintenances")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @Operation(summary = "Lister les maintenances")
    @GetMapping
    public List<MaintenanceDTO> findAll() {
        return maintenanceService.findAll();
    }

    @Operation(summary = "Consulter une maintenance")
    @GetMapping("/{id}")
    public MaintenanceDTO findById(
            @PathVariable Long id) {

        return maintenanceService.findById(id);
    }

    @Operation(summary = "Créer une maintenance")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MaintenanceDTO create(
            @Valid
            @RequestBody MaintenanceDTO dto) {

        return maintenanceService.create(dto);
    }

    @Operation(summary = "Modifier une maintenance")
    @PutMapping("/{id}")
    public MaintenanceDTO update(
            @PathVariable Long id,
            @Valid
            @RequestBody MaintenanceDTO dto) {

        return maintenanceService.update(id, dto);
    }

    @Operation(summary = "Supprimer une maintenance")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @PathVariable Long id) {

        maintenanceService.deleteById(id);
    }
}