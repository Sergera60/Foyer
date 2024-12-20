package tn.esprit.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Bloc;
import tn.esprit.entities.Chambre;
import tn.esprit.entities.Foyer;
import tn.esprit.repositories.BlocRepository;
import tn.esprit.repositories.ChambreRepository;
import tn.esprit.repositories.FoyerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
    BlocRepository bl;
    FoyerRepository foy ;
    ChambreRepository ch ;


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

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) { // 2 parametre pas de cascades

  Bloc blo = bl.findById(idBloc).get();
  List<Chambre> chambres = new ArrayList<>();
    for (Long num : numChambre) {
        Chambre c = ch.findByNumChambre(num);
        chambres.add(c);
    }
     ch.saveAll(chambres);
    for(Chambre c : chambres){
        c.setBloc(blo);
        ch.save(c);
    }
    return blo;
}


@Scheduled(fixedDelay = 60000)
    public void getChambres(){
        //get all chambre in bloc
    List<Bloc> blocs = bl.findAll();
    for(Bloc b : blocs){
        log.info("Bloc => "+b.getNomBloc()+"ayant une capacite " + b.getCapaciteBloc() );
        List<Chambre> chambres = b.getChambres();
        for(Chambre c : chambres){
           log.info("chambre" + c.getNumChambre());
        }
    }


}

}
