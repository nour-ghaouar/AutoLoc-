package tn.esprit.autolocapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autolocapi.domain.Agence;
import tn.esprit.autolocapi.domain.Employe;
import tn.esprit.autolocapi.exception.ResourceNotFoundException;
import tn.esprit.autolocapi.mapper.EmployeMapper;
import tn.esprit.autolocapi.repository.IAgenceRepository;
import tn.esprit.autolocapi.repository.IEmployeRepository;
import tn.esprit.autolocapi.web.dto.EmployeDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl
        implements IEmployeService {

    private final IEmployeRepository employeRepository;
    private final IAgenceRepository agenceRepository;
    private final EmployeMapper employeMapper;

    @Override
    public EmployeDTO create(
            EmployeDTO dto) {

        if (dto.idEmploye() != null) {
            throw new IllegalArgumentException(
                    "Un nouvel employé ne doit pas avoir d'identifiant"
            );
        }

        Employe employe =
                employeMapper.toEntity(dto);

        employe.setAgence(
                getAgence(dto.agenceId())
        );

        employe =
                employeRepository.save(employe);

        return employeMapper.toDTO(employe);
    }

    @Override
    public EmployeDTO findById(Long id) {

        return employeMapper.toDTO(
                getEmploye(id)
        );
    }

    @Override
    public List<EmployeDTO> findAll() {

        return employeRepository
                .findAll()
                .stream()
                .map(employeMapper::toDTO)
                .toList();
    }

    @Override
    public EmployeDTO update(
            Long id,
            EmployeDTO dto) {

        Employe employe =
                getEmploye(id);

        employeMapper.updateEntity(
                dto,
                employe
        );

        employe.setAgence(
                getAgence(dto.agenceId())
        );

        employe =
                employeRepository.save(employe);

        return employeMapper.toDTO(employe);
    }

    @Override
    public void deleteById(Long id) {

        if (!employeRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Employe",
                    id
            );
        }

        employeRepository.deleteById(id);
    }

    private Employe getEmploye(Long id) {

        return employeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employe",
                                id
                        ));
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