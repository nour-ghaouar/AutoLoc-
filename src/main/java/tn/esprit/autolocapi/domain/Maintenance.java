package tn.esprit.autolocapi.domain;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;

@Entity
@Table(name = "maintenance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Vehicule vehicule;
}