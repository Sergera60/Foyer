package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Foyer;
import tn.esprit.entities.Universite;
import tn.esprit.repositories.FoyerRepository;
import tn.esprit.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepository uni;
    FoyerRepository foy ;

    @Override
    public Universite addUniversite(Universite universite) {
        return uni.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return uni.save(universite);
    }

    @Override
    public void deleteUniversite(Long id) {
        uni.deleteById(id);
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return uni.findById(id).get();
    }

    @Override
    public List<Universite> allUniversites() {
        return uni.findAll();
    }


    //affectation
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
       Foyer f = foy.findById(idFoyer).get();
       Universite unive = uni.findByNomUniversite(nomUniversite);
    unive.setFoyer(f);
    uni.save(unive);
    return unive;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite unive = uni.findById(idUniversite).get();
        unive.setFoyer(null);
        uni.save(unive);

        return unive;
    }




}
