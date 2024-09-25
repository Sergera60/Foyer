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
public class Bloc  implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
private long idBloc ;
    private String nomBloc;
    private long capaciteBloc ;



}
