package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Client;
import java.util.List;

public interface IClientService {

    Client addClient(Client client);

    List<Client> getAllClients();

    Client getClientById(Long id);

    void deleteClient(Long id);
}