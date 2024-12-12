package tn.esprit.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.entities.Classe;
import tn.esprit.services.IClasseService;


@RestController
@AllArgsConstructor
@RequestMapping("/Classe")
public class ClasseController {


IClasseService classeService ;

    @PostMapping("/add-classe")
    public Classe addUser(@RequestBody Classe classe){

        Classe classe1 =classeService.addClasse(classe) ;
        return classe1 ;
    }


}
