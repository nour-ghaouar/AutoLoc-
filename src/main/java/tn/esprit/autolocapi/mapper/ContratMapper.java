package tn.esprit.autolocapi.mapper;

import org.springframework.stereotype.Component;
import tn.esprit.autolocapi.domain.Contrat;
import tn.esprit.autolocapi.web.dto.ContratDTO;

@Component
public class ContratMapper {

    public Contrat toEntity(ContratDTO dto) {

        Contrat contrat = new Contrat();

        contrat.setDateSignature(dto.dateSignature());
        contrat.setMontantTotal(dto.montantTotal());
        contrat.setValide(dto.valide());

        return contrat;
    }

    public ContratDTO toDTO(Contrat contrat) {

        Long reservationId =
                contrat.getReservation() != null
                        ? contrat.getReservation()
                        .getIdReservation()
                        : null;

        return new ContratDTO(
                contrat.getIdContrat(),
                contrat.getDateSignature(),
                contrat.getMontantTotal(),
                contrat.isValide(),
                reservationId
        );
    }

    public void updateEntity(
            ContratDTO dto,
            Contrat contrat) {

        contrat.setDateSignature(dto.dateSignature());
        contrat.setMontantTotal(dto.montantTotal());
        contrat.setValide(dto.valide());
    }
}