package tn.esprit.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Niveau;
import tn.esprit.entities.Utilisateur;
import tn.esprit.services.IUtilisateurService;


@RestController
@AllArgsConstructor
@RequestMapping("/Utilisateur")

public class UtilisateurController {
IUtilisateurService util ;


@PostMapping("/add-utilisateur")
public Utilisateur addUser(@RequestBody Utilisateur utilisateur){

Utilisateur utili =util.addUser(utilisateur) ;
return utili ;
}

@PostMapping("/affecterUtilisateurClasse")
public void affecterUtilisateurClasse(@RequestParam Integer idUtilisateur, @RequestParam Integer codeClasse){

    util.affecterUtilisateurClasse(idUtilisateur, codeClasse);
}

@GetMapping("/nbUtilisateurParNiveau")
public Integer nbUtilisateurParNiveau(@RequestParam Niveau niveau) {

    return util.nbUtilisateurParNiveau(niveau);
}







}
