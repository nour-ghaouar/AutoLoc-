package tn.esprit.autolocapi.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String numPermis;
    private LocalDate dateInscription;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.PERSIST
    )
    private List<Reservation> reservations = new ArrayList<>();
}