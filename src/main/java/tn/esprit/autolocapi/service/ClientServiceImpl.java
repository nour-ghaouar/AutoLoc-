package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Client;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.ClientMapper;
import tn.esprit.autolocapi.repository.IClientRepository;
import tn.esprit.autolocapi.web.dto.ClientDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl
        implements IClientService {

    private final IClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDTO create(ClientDTO dto) {

        if (dto.idClient() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau client ne doit pas avoir d'identifiant"
            );
        }

        Client client =
                clientMapper.toEntity(dto);

        client =
                clientRepository.save(client);

        return clientMapper.toDTO(client);
    }

    @Override
    public ClientDTO findById(Long id) {
        return clientMapper.toDTO(
                getClient(id)
        );
    }

    @Override
    public List<ClientDTO> findAll() {

        return clientRepository
                .findAll()
                .stream()
                .map(clientMapper::toDTO)
                .toList();
    }

    @Override
    public ClientDTO update(
            Long id,
            ClientDTO dto) {

        Client client = getClient(id);

        clientMapper.updateEntity(
                dto,
                client
        );

        client =
                clientRepository.save(client);

        return clientMapper.toDTO(client);
    }

    @Override
    public void deleteById(Long id) {

        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Client",
                    id
            );
        }

        clientRepository.deleteById(id);
    }

    private Client getClient(Long id) {

        return clientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Client",
                                id
                        ));
    }
}