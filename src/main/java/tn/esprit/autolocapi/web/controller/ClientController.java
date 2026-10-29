package tn.esprit.autolocapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.service.IClientService;
import tn.esprit.autolocapi.web.dto.ClientDTO;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Tag(name = "Clients")
public class ClientController {

    private final IClientService clientService;

    @Operation(summary = "Lister les clients")
    @GetMapping
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    @Operation(summary = "Consulter un client")
    @GetMapping("/{id}")
    public ClientDTO findById(
            @PathVariable Long id) {

        return clientService.findById(id);
    }

    @Operation(summary = "Créer un client")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO create(
            @Valid
            @RequestBody ClientDTO dto) {

        return clientService.create(dto);
    }

    @Operation(summary = "Modifier un client")
    @PutMapping("/{id}")
    public ClientDTO update(
            @PathVariable Long id,
            @Valid
            @RequestBody ClientDTO dto) {

        return clientService.update(id, dto);
    }

    @Operation(summary = "Supprimer un client")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(
            @PathVariable Long id) {

        clientService.deleteById(id);
    }
}