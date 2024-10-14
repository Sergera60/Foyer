package tn.esprit.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Etudiant;
import tn.esprit.services.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Etudiant")
public class EtudiantRestController {
    IEtudiantService etudiantService;

    @GetMapping("retrieve-all-Etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.allEtudiants();
        return listEtudiants;
    }

    @GetMapping("/retrieve-Etudiant/{Etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("Etudiant-id") Long eId) {
        Etudiant etudiant = etudiantService.getEtudiantById(eId);
        return etudiant;
    }

    @PostMapping("/add-Etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }

    @PostMapping("/update-Etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.updateEtudiant(e);
        return etudiant;
    }
    @PostMapping("/delete-Etudiant")
    public void deleteEtudiant(@RequestBody Long eId) {
        etudiantService.deleteEtudiant(eId);
    }

}
