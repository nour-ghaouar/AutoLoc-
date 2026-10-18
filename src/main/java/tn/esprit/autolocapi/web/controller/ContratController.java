package tn.esprit.autolocapi.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocapi.service.IContratService;

@RestController
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;
}