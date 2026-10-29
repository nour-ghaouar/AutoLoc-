package tn.esprit.autolocapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.service.IPaiementService;
import tn.esprit.autolocapi.web.dto.PaiementDTO;

import java.util.List;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
@Tag(name = "Paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    @Operation(summary = "Lister les paiements")
    @GetMapping
    public List<PaiementDTO> findAll() {
        return paiementService.findAll();
    }

    @Operation(summary = "Consulter un paiement")
    @GetMapping("/{id}")
    public PaiementDTO findById(
            @PathVariable Long id) {

        return paiementService.findById(id);
    }
}