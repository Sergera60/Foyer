package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Universite;
import tn.esprit.repositories.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepository uni;

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
}
