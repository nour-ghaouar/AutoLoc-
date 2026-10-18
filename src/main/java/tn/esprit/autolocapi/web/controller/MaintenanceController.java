package tn.esprit.autolocapi.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocapi.service.IMaintenanceService;

@RestController
@RequiredArgsConstructor
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;
}