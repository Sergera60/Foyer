package tn.esprit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

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




}
