package tn.esprit.autolocapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.service.IEquipementService;
import tn.esprit.autolocapi.web.dto.EquipementDTO;

import java.util.List;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
@Tag(name = "Equipements")
public class EquipementController {

    private final IEquipementService equipementService;

    @Operation(summary = "Lister les équipements")
    @GetMapping
    public List<EquipementDTO> findAll() {
        return equipementService.findAll();
    }

    @Operation(summary = "Consulter un équipement")
    @GetMapping("/{id}")
    public EquipementDTO findById(
            @PathVariable Long id) {

        return equipementService.findById(id);
    }

    @Operation(summary = "Créer un équipement")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EquipementDTO create(
            @Valid
            @RequestBody EquipementDTO dto) {

        return equipementService.create(dto);
    }

    @Operation(summary = "Modifier un équipement")
    @PutMapping("/{id}")
    public EquipementDTO update(
            @PathVariable Long id,
            @Valid
            @RequestBody EquipementDTO dto) {

        return equipementService.update(id, dto);
    }

    @Operation(summary = "Supprimer un équipement")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @PathVariable Long id) {

        equipementService.deleteById(id);
    }
}