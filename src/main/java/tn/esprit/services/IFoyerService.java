package tn.esprit.services;

import tn.esprit.entities.Foyer;

import java.util.List;

public interface IFoyerService {

    Foyer addFoyer(Foyer foyer);

    Foyer updateFoyer(Foyer foyer);

    void deleteFoyer(Long id);

    Foyer getFoyerById(Long id);

    List<Foyer> allFoyers();

}
