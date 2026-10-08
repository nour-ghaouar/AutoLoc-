package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Employe;
import java.util.List;

public interface IEmployeService {

    Employe addEmploye(Employe employe);

    List<Employe> getAllEmployes();

    Employe getEmployeById(Long id);

    void deleteEmploye(Long id);
}