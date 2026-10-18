package tn.esprit.autolocapi.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autolocapi.service.IClientService;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final IClientService clientService;
}