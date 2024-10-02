package tn.esprit.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEtudiant ;
    private String nomEt ;
    private String prenomEt;
    private  long cin ;
    private String ecole ;
    private Date dateDeNaissance ;
    @ManyToMany(mappedBy = "etudiants")
   private List<Reservation> reservations ;




}
