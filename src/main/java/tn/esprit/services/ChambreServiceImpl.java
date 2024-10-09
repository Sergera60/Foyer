package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Chambre;
import tn.esprit.repositories.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {


    ChambreRepository ch ;


    @Override
    public Chambre addChambre(Chambre chambre) {

        return  ch.save(chambre);
    }
    @Override
    public Chambre updateChambre(Chambre chambre) {

        return ch.save(chambre);
    }
    @Override
    public void deleteChambre(Long id) {
        ch.deleteById(id);
    }
    @Override
    public Chambre getChambre(Long id) {
        return  ch.findById(id).get();
    }
    @Override
    public List<Chambre> allChambres() {
        return ch.findAll();
    }






}
