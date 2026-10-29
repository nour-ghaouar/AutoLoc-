package tn.esprit.autolocapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.service.IEmployeService;
import tn.esprit.autolocapi.web.dto.EmployeDTO;

import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
@Tag(name = "Employes")
public class EmployeController {

    private final IEmployeService employeService;

    @Operation(summary = "Lister les employés")
    @GetMapping
    public List<EmployeDTO> findAll() {
        return employeService.findAll();
    }

    @Operation(summary = "Consulter un employé")
    @GetMapping("/{id}")
    public EmployeDTO findById(
            @PathVariable Long id) {

        return employeService.findById(id);
    }

    @Operation(summary = "Créer un employé")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeDTO create(
            @Valid
            @RequestBody EmployeDTO dto) {

        return employeService.create(dto);
    }

    @Operation(summary = "Modifier un employé")
    @PutMapping("/{id}")
    public EmployeDTO update(
            @PathVariable Long id,
            @Valid
            @RequestBody EmployeDTO dto) {

        return employeService.update(id, dto);
    }

    @Operation(summary = "Supprimer un employé")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @PathVariable Long id) {

        employeService.deleteById(id);
    }
}