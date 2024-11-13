package tn.esprit.services;

import tn.esprit.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite universite);

    Universite updateUniversite(Universite universite);

    void deleteUniversite(Long id);

    Universite getUniversiteById(Long id);

    List<Universite> allUniversites();

    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;

    public Universite desaffecterFoyerAUniversite (long idUniversite) ;

}
