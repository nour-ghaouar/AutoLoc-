package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.AgenceMapper;
import tn.esprit.autolocapi.repository.IAgenceRepository;
import tn.esprit.autolocapi.web.dto.AgenceDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl
        implements IAgenceService {

    private final IAgenceRepository agenceRepository;
    private final AgenceMapper agenceMapper;

    @Override
    public AgenceDTO create(AgenceDTO dto) {

        if (dto.idAgence() != null) {
            throw new IllegalArgumentException(
                    "Une nouvelle agence ne doit pas avoir d'identifiant"
            );
        }

        Agence agence =
                agenceMapper.toEntity(dto);

        agence = agenceRepository.save(agence);

        return agenceMapper.toDTO(agence);
    }

    @Override
    public AgenceDTO findById(Long id) {
        return agenceMapper.toDTO(
                getAgence(id)
        );
    }

    @Override
    public List<AgenceDTO> findAll() {

        return agenceRepository
                .findAll()
                .stream()
                .map(agenceMapper::toDTO)
                .toList();
    }

    @Override
    public AgenceDTO update(
            Long id,
            AgenceDTO dto) {

        Agence agence = getAgence(id);

        agenceMapper.updateEntity(
                dto,
                agence
        );

        agence =
                agenceRepository.save(agence);

        return agenceMapper.toDTO(agence);
    }

    @Override
    public void deleteById(Long id) {

        if (!agenceRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Agence",
                    id
            );
        }

        agenceRepository.deleteById(id);
    }

    private Agence getAgence(Long id) {

        return agenceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Agence",
                                id
                        ));
    }
}