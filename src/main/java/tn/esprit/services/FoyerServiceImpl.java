package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Foyer;
import tn.esprit.repositories.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foy;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foy.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foy.save(foyer);
    }

    @Override
    public void deleteFoyer(Long id) {

        foy.deleteById(id);
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foy.findById(id).get();
    }

    @Override
    public List<Foyer> allFoyers() {
        return foy.findAll();
    }
}
