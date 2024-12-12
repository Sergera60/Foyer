package tn.esprit.services;


import tn.esprit.entities.Niveau;
import tn.esprit.entities.Utilisateur;

public interface IUtilisateurService {

Utilisateur addUser(Utilisateur util);

void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse);

Integer nbUtilisateurParNiveau(Niveau niveau);


}
