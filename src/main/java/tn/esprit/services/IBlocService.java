package tn.esprit.services;

import tn.esprit.entities.Bloc;
import tn.esprit.entities.Foyer;

import java.util.List;

public interface IBlocService {

    Bloc addBloc(Bloc bloc);

    Bloc updateBloc(Bloc bloc);

    void deleteBloc(long id);

    Bloc getBlocById(long id);

    List<Bloc> allBlocs();

    public Bloc affecterBlocAFoyer(String nomBloc, Foyer foyer) ;
    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;


}
