package tn.esprit.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;

    private long numChambre;

    @Enumerated(value = EnumType.STRING)
    private TypeChambre TypeC;
    @ManyToOne
    private Bloc bloc ;
    @OneToMany
    private List<Reservation> reservations;


}
