package tn.esprit.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Bloc;
import tn.esprit.entities.Chambre;
import tn.esprit.entities.Reservation;
import tn.esprit.entities.TypeChambre;
import tn.esprit.repositories.BlocRepository;
import tn.esprit.repositories.ChambreRepository;
import tn.esprit.repositories.ReservationRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
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

    @Scheduled(fixedDelay = 60000)
    public void fixedDelayMethod(){
        log.info("Method with fixed delay ");
    }


    @Scheduled(fixedDelay = 300000)
    public void pourcentageChambreParTypeChambre(){
        List<Chambre> chambres = ch.findAll();
        int nbrChambreSimple = 0;
        int nbrChambreDouble = 0;
        int nbrChambreTriple = 0;
        int total=0;
        for(Chambre c : chambres){
           log.info( "type chambre "+c.getTypeC());

            if(c.getTypeC() == TypeChambre.SIMPLE){
                nbrChambreSimple = nbrChambreSimple + 1;
                log.info("nbr chambre simple "+nbrChambreSimple);
            }
            else if(c.getTypeC() == TypeChambre.DOUBLE){
                nbrChambreDouble= nbrChambreDouble+1;
            }
            else if(c.getTypeC() == TypeChambre.TRIPLE){
                nbrChambreTriple= nbrChambreTriple+1;
            }
        }
        total = nbrChambreSimple + nbrChambreDouble + nbrChambreTriple;
        log.info("chambre"+total);
        log.info("Pourcentage de chambre SIMPLE : " + (nbrChambreSimple*100)/total + "%");
        log.info("Pourcentage de chambre DOUBLE : " + (nbrChambreDouble*100)/total + "%");
        log.info("Pourcentage de chambre TRIPLE : " + (nbrChambreTriple*100)/total + "%");
    }


    @Scheduled(fixedDelay = 300000)
    public void nbPlacesDisponibleParChambreAnneeEnCour(){
        List<Chambre> chambres = ch.findAll();
      int capaciteChambre =0 ;
        int nbrPlaceOccupe = 0;
        int nbrPlaceDispo = 0;
        for(Chambre c : chambres){

           if(c.getTypeC() == TypeChambre.SIMPLE){
               capaciteChambre = 1;}
              else if(c.getTypeC() == TypeChambre.DOUBLE){
                capaciteChambre = 2;}
              else if(c.getTypeC() == TypeChambre.TRIPLE){
                capaciteChambre = 3;
           }
              for (Reservation r: c.getReservations()){
                 if(r.getEstValide()){
                     nbrPlaceOccupe = c.getReservations().size();
                     nbrPlaceDispo = capaciteChambre - nbrPlaceOccupe;
                 }else if(!r.getEstValide()) {

                        nbrPlaceDispo = capaciteChambre;
                 }

              }
            if (nbrPlaceDispo==0){
                log.info("Pas de chambre disponible ");
            }else {
            log.info("Chambre "+c.getNumChambre()+" Nombre de place disponible : "+nbrPlaceDispo);
        }}
    }





}
