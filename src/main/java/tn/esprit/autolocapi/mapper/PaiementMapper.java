package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Paiement;
import tn.esprit.autolocapi.web.dto.PaiementDTO;

@Component
public class PaiementMapper {

    public PaiementDTO toDTO(
            Paiement paiement) {

        Long contratId =
                paiement.getContrat() != null
                        ? paiement.getContrat().getIdContrat()
                        : null;

        return new PaiementDTO(
                paiement.getIdPaiement(),
                paiement.getMontant(),
                paiement.getDatePaiement(),
                paiement.getModePaiement(),
                contratId
        );
    }
}