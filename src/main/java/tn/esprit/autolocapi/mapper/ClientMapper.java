package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Client;
import tn.esprit.autolocapi.web.dto.ClientDTO;

@Component
public class ClientMapper {

    public Client toEntity(ClientDTO dto) {
        Client client = new Client();
        updateEntity(dto, client);
        return client;
    }

    public ClientDTO toDTO(Client client) {

        return new ClientDTO(
                client.getIdClient(),
                client.getNom(),
                client.getPrenom(),
                client.getEmail(),
                client.getTelephone(),
                client.getNumPermis(),
                client.getDateInscription()
        );
    }

    public void updateEntity(
            ClientDTO dto,
            Client client) {

        client.setNom(dto.nom());
        client.setPrenom(dto.prenom());
        client.setEmail(dto.email());
        client.setTelephone(dto.telephone());
        client.setNumPermis(dto.numPermis());
        client.setDateInscription(dto.dateInscription());
    }
}