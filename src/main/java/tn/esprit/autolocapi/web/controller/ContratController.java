package tn.esprit.autolocapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.service.IContratService;
import tn.esprit.autolocapi.web.dto.ContratDTO;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
@Tag(name = "Contrats")
public class ContratController {

    private final IContratService contratService;

    @Operation(summary = "Lister les contrats")
    @GetMapping
    public List<ContratDTO> findAll() {
        return contratService.findAll();
    }

    @Operation(summary = "Consulter un contrat")
    @GetMapping("/{id}")
    public ContratDTO findById(
            @PathVariable Long id) {

        return contratService.findById(id);
    }

    @Operation(summary = "Créer un contrat")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContratDTO create(
            @Valid
            @RequestBody ContratDTO dto) {

        return contratService.create(dto);
    }

    @Operation(summary = "Modifier un contrat")
    @PutMapping("/{id}")
    public ContratDTO update(
            @PathVariable Long id,
            @Valid
            @RequestBody ContratDTO dto) {

        return contratService.update(id, dto);
    }

    @Operation(summary = "Supprimer un contrat")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @PathVariable Long id) {

        contratService.deleteById(id);
    }
}