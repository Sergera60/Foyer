package tn.esprit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CoursClassroom implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer idCours;
    @Enumerated(value = EnumType.STRING)
    private Specialite specialite ;
    private String nom ;
    private Integer nbHeures ;
    private  boolean archive ;

    @ManyToOne
    @JsonIgnore
    private Classe classe ;
}
