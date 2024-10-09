package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Bloc;
import tn.esprit.repositories.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    BlocRepository bl;


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
}
