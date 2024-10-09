package tn.esprit.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import tn.esprit.entities.Chambre;

import java.util.List;


public interface IChambreService {


    Chambre addChambre(Chambre chambre);

    Chambre updateChambre(Chambre chambre);

    void deleteChambre(Long id);


    Chambre getChambre(Long id);

    List<Chambre> allChambres();


}
