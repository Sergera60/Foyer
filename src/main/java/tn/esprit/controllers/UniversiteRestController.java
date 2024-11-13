package tn.esprit.controllers;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Universite;
import tn.esprit.services.IUniversiteService;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    IUniversiteService universiteService;
    @GetMapping("retrieve-all-universites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.allUniversites();
        return listUniversites;
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long uId) {
        Universite universite = universiteService.getUniversiteById(uId);
        return universite;
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }

    @PostMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.updateUniversite(u);
        return universite;
    }
    @PostMapping("/delete-universite")
    public void deleteUniversite(@RequestBody Long uId) {
        universiteService.deleteUniversite(uId);
    }

@PostMapping("/affecterFoyerAUniversite")
    public Universite affecterFoyerAUniversite(@RequestBody long idFoyer , String nomUniversite) {
        Universite universite = universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
        return universite;
    }

@PostMapping("/desaffecterFoyerAUniversite")
    public Universite desaffecterFoyerAUniversite(@RequestBody long idUniversite) {
        Universite universite = universiteService.desaffecterFoyerAUniversite(idUniversite);
        return universite;
    }



}
