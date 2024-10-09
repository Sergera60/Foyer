package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Etudiant;
import tn.esprit.repositories.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    EtudiantRepository et;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return et.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return et.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Long id) {
        et.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return et.findById(id).get();
    }

    @Override
    public List<Etudiant> allEtudiants() {
        return et.findAll();
    }
}
