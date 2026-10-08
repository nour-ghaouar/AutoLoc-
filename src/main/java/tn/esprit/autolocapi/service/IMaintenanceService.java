package tn.esprit.autolocapi.service;

import tn.esprit.autolocapi.domain.Maintenance;
import java.util.List;

public interface IMaintenanceService {

    Maintenance addMaintenance(Maintenance maintenance);

    List<Maintenance> getAllMaintenances();

    Maintenance getMaintenanceById(Long id);

    void deleteMaintenance(Long id);
}