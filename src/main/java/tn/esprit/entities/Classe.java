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
public class Classe  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer codeClasse;
    private String titre ;
    @Enumerated(value = EnumType.STRING)
    private Niveau niveau ;
    @OneToMany(mappedBy = "classe")
    private List<CoursClassroom> coursClassroom ;

}
