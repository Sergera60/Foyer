package tn.esprit.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtilisateur ;
    private String prenom ;
    private String nom ;
    private String password ;

    @ManyToOne
    private Classe classe ;



}
