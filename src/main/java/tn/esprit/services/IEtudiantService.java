package tn.esprit.services;

import tn.esprit.entities.Etudiant;

import java.util.Date;
import java.util.List;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant etudiant);

    Etudiant updateEtudiant(Etudiant etudiant);

    void deleteEtudiant(Long id);

    Etudiant getEtudiantById(Long id);

    List<Etudiant> allEtudiants();
    List<String> findNomsEtudiantsReservationsValides(Date anneeUniversitaire);

    List<String> findNomsEtudiantsReservationsValides2(Date anneeUniversitaire);
}
