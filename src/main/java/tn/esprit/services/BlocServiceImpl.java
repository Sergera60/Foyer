package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Bloc;
import tn.esprit.entities.Foyer;
import tn.esprit.repositories.BlocRepository;
import tn.esprit.repositories.FoyerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    BlocRepository bl;
    FoyerRepository foy ;


    @Override
    public Bloc addBloc(Bloc bloc) {
        return bl.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return bl.save(bloc);
    }

    @Override
    public void deleteBloc(long id) {

        bl.deleteById(id);
    }

    @Override
    public Bloc getBlocById(long id) {
        return bl.findById(id).get();
    }

    @Override
    public List<Bloc> allBlocs() {
        return bl.findAll();
    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, Foyer foyer) {
    Foyer foyer1 = foy.findById(foyer.getIdFoyer()).get();
    Bloc bloc = bl.findByNomBloc(nomBloc) ;

    bloc.setFoyer(foyer1);
    bl.save(bloc);
    return bloc;
    }


}
