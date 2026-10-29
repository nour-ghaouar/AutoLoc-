package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Paiement;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.PaiementMapper;
import tn.esprit.autolocapi.repository.IPaiementRepository;
import tn.esprit.autolocapi.web.dto.PaiementDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl
        implements IPaiementService {

    private final IPaiementRepository paiementRepository;
    private final PaiementMapper paiementMapper;

    @Override
    public PaiementDTO findById(Long id) {

        Paiement paiement =
                paiementRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Paiement",
                                        id
                                ));

        return paiementMapper.toDTO(
                paiement
        );
    }

    @Override
    public List<PaiementDTO> findAll() {

        return paiementRepository
                .findAll()
                .stream()
                .map(paiementMapper::toDTO)
                .toList();
    }
}