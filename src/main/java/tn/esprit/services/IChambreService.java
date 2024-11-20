package tn.esprit.services;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import tn.esprit.entities.Chambre;

import java.util.Date;
import java.util.List;


public interface IChambreService {


    Chambre addChambre(Chambre chambre);

    Chambre updateChambre(Chambre chambre);

    void deleteChambre(Long id);

Integer nbrChambresSelonCapaciteFoyer(Long capaciteFoyer);

    Chambre getChambre(Long id);

    List<Chambre> allChambres();

    List<Chambre> chambresSelonNomBloc(String nomBloc);

    List<Chambre> chambresSelonAnnesRes(Date d1 , Date d2);
    List<Chambre> addListChambres(List<Chambre> chs);



    List<Chambre> chambresSelonNomBlocQuery(String nomBloc);


    List<Chambre> chambreSelonAnneeUniversitaireQuery(Date d1, Date d2);


    Integer countChambresReservationsNonValides(Date anneeUniversitaire);

    Integer countChambresReservationsNonValidesQuery(Date anneeUniversitaire);
    Chambre affecterChambreABloc (Long num, Integer idBloc);

    void desaffecterChambreDeBloc (Long num, Integer idBloc);


}
