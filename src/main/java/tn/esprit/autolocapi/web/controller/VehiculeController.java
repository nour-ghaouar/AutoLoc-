package tn.esprit.autolocapi.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocapi.service.IVehiculeService;

@RestController
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;
}