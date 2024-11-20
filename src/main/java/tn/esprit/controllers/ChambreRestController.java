package tn.esprit.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Chambre;
import tn.esprit.services.IChambreService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;
    @GetMapping("retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.allChambres();
        return listChambres;
    }
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.getChambre(chId);
        return chambre;
}

    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.deleteChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.updateChambre(c);
        return chambre;
    }

    @GetMapping("/chambresSelonBloc/{nomBloc}")
    public List<Chambre> chambresSelonNomBloc(@PathVariable String nomBloc) {
        return chambreService.chambresSelonNomBloc(nomBloc);
    }


     @GetMapping("/chambresSelonAnnesRes/{d1}/{d2}")
    public List<Chambre> chambresSelonAnnesRes(@PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date d1, @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date d2) {
        return chambreService.chambresSelonAnnesRes(d1, d2);
    }

    @GetMapping("/nbrChambresSelonCapaciteFoyer/{capaciteFoyer}")
    public Integer nbrChambresSelonCapaciteFoyer(@PathVariable Long capaciteFoyer) {
        return chambreService.nbrChambresSelonCapaciteFoyer(capaciteFoyer);
    }


    @GetMapping("/chambresSelonNomBlocQuery/{nomBloc}")
    public List<Chambre> chambresSelonNomBlocQuery(@PathVariable String nomBloc) {
        return chambreService.chambresSelonNomBlocQuery(nomBloc);
    }


    @GetMapping("/chambreSelonAnneeUniversitaireQuery/{d1}/{d2}")
    public List<Chambre> chambreSelonAnneeUniversitaireQuery(@PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date d1, @PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd") Date d2) {
        return chambreService.chambreSelonAnneeUniversitaireQuery(d1, d2);
    }



    @GetMapping("/countChambresReservationsNonValides/{anneeUniversitaire}")
    public Integer countChambresReservationsNonValides(@PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd")  Date anneeUniversitaire) {
        return chambreService.countChambresReservationsNonValides(anneeUniversitaire);
    }

    @GetMapping("/countChambresReservationsNonValidesQuery/{anneeUniversitaire}")
    public Integer countChambresReservationsNonValidesQuery(@PathVariable @DateTimeFormat(pattern = "yyyy-mm-dd")  Date anneeUniversitaire) {
        return chambreService.countChambresReservationsNonValidesQuery(anneeUniversitaire);
    }
    @PostMapping("/affecterChambreABloc")
    public Chambre affecterChambreABloc(@RequestParam Long num, @RequestParam Integer idBloc) {
        return chambreService.affecterChambreABloc(num, idBloc);
    }
    @PostMapping("/desaffecterChambreDeBloc")
    public void desaffecterChambreDeBloc(@RequestParam Long num, @RequestParam Integer idBloc) {
        chambreService.desaffecterChambreDeBloc(num, idBloc);
    }
}
