package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Bloc;
import tn.esprit.entities.Chambre;
import tn.esprit.repositories.BlocRepository;
import tn.esprit.repositories.ChambreRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {


    ChambreRepository ch ;
    BlocRepository bl;


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
    public Integer nbrChambresSelonCapaciteFoyer(Long capaciteFoyer) {
        return ch.countByBloc_Foyer_CapaciteFoyerLessThan(capaciteFoyer);
    }

    @Override
    public Chambre getChambre(Long id) {
        return  ch.findById(id).get();
    }
    @Override
    public List<Chambre> allChambres() {
        return ch.findAll();
    }

    @Override
    public List<Chambre> chambresSelonNomBloc(String nomBloc) {
        return ch.findByBloc_NomBloc(nomBloc);
    }



    @Override
    public List<Chambre> chambresSelonAnnesRes(Date d1, Date d2) {
        return ch.findByReservations_AnneeUniversitaireBetween(d1, d2);
    }


    @Override
    public List<Chambre> addListChambres(List<Chambre> chs) {
        return ch.saveAll(chs);
    }

    @Override
    public List<Chambre> chambresSelonNomBlocQuery(String nomBloc) {
        return ch.chambresSelonNomBloc(nomBloc);
    }

    @Override
    public List<Chambre> chambreSelonAnneeUniversitaireQuery(Date d1, Date d2) {
        return ch.ReservationAnneUniversitaire(d1, d2);
    }

    @Override
    public Integer countChambresReservationsNonValides(Date anneeUniversitaire) {
        return ch.countByReservations_EstValideFalseAndReservations_AnneeUniversitaireBefore(anneeUniversitaire);
    }

    @Override
    public Integer countChambresReservationsNonValidesQuery(Date anneeUniversitaire) {
        return ch.countChambresReservationsNonValides(anneeUniversitaire);
    }

    @Override
    public Chambre affecterChambreABloc(Long num, Integer idBloc) {
        Chambre c = ch.findByNumChambre(num);
        Long id = Long.valueOf(idBloc);
        Bloc b = bl.findById(id).get();
        c.setBloc(b);
        return ch.save(c);
    }

    @Override
    public void desaffecterChambreDeBloc(Long num, Integer idBloc) {
        Chambre c = ch.findByNumChambre(num);
        Bloc b = bl.findById(Long.valueOf(idBloc)).get();
        b.getChambres().remove(c);
       ch.save(c);

    }


}
