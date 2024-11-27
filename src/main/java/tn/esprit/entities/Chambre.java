package tn.esprit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Bloc bloc ;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Reservation> reservations;


}
