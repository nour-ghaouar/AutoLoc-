package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.domain.Reservation;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.ContratMapper;
import tn.esprit.autolocapi.repository.IContratRepository;
import tn.esprit.autolocapi.repository.IReservationRepository;
import tn.esprit.autolocapi.web.dto.ContratDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl
        implements IContratService {

    private final IContratRepository contratRepository;
    private final IReservationRepository reservationRepository;
    private final ContratMapper contratMapper;

    @Override
    public ContratDTO create(ContratDTO dto) {

        if (dto.idContrat() != null) {
            throw new IllegalArgumentException(
                    "Un nouveau contrat ne doit pas avoir d'identifiant"
            );
        }

        Contrat contrat =
                contratMapper.toEntity(dto);

        if (dto.reservationId() != null) {
            contrat.setReservation(
                    getReservation(
                            dto.reservationId()
                    )
            );
        }

        contrat =
                contratRepository.save(contrat);

        return contratMapper.toDTO(contrat);
    }

    @Override
    public ContratDTO findById(Long id) {

        return contratMapper.toDTO(
                getContrat(id)
        );
    }

    @Override
    public List<ContratDTO> findAll() {

        return contratRepository
                .findAll()
                .stream()
                .map(contratMapper::toDTO)
                .toList();
    }

    @Override
    public ContratDTO update(
            Long id,
            ContratDTO dto) {

        Contrat contrat =
                getContrat(id);

        contratMapper.updateEntity(
                dto,
                contrat
        );

        if (dto.reservationId() != null) {
            contrat.setReservation(
                    getReservation(
                            dto.reservationId()
                    )
            );
        }

        contrat =
                contratRepository.save(contrat);

        return contratMapper.toDTO(contrat);
    }

    @Override
    public void deleteById(Long id) {

        if (!contratRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Contrat",
                    id
            );
        }

        contratRepository.deleteById(id);
    }

    private Contrat getContrat(Long id) {

        return contratRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Contrat",
                                id
                        ));
    }

    private Reservation getReservation(
            Long id) {

        return reservationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reservation",
                                id
                        ));
    }
}