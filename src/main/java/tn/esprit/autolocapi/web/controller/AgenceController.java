package tn.esprit.autolocapi.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocapi.service.IAgenceService;

@RestController
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;
}