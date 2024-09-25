package tn.esprit.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Reservation  implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String idReservation ;
    private Date anneeUniversitaire ;
    private Boolean estValide;



}
