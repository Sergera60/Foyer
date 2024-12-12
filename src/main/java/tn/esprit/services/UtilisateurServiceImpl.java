package tn.esprit.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Niveau;
import tn.esprit.entities.Utilisateur;
import tn.esprit.repositories.ClasseRepository;
import tn.esprit.repositories.UtilisateurRepository;


@Service
@AllArgsConstructor
public class UtilisateurServiceImpl  implements IUtilisateurService  {



UtilisateurRepository uti ;
ClasseRepository classeRepository;
    @Override
    public Utilisateur addUser(Utilisateur util) {
        return uti.save(util);
    }

    @Override
    public void affecterUtilisateurClasse(Integer idUtilisateur, Integer codeClasse) {
        Utilisateur utilisateur = uti.findById(idUtilisateur).get();
      utilisateur.setClasse(classeRepository.findById(codeClasse).get());
        uti.save(utilisateur);
    }

    @Override
    public Integer nbUtilisateurParNiveau(Niveau niveau) {
        return uti.countByClasse_Niveau(niveau);
    }





}
