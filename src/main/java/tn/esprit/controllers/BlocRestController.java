package tn.esprit.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.entities.Bloc;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Foyer;
import tn.esprit.services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    @GetMapping("retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.allBlocs();
        return listBlocs;
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long bId) {
        Bloc bloc = blocService.getBlocById(bId);
        return bloc;
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    @PostMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.updateBloc(b);
        return bloc;
    }
    @PostMapping("/delete-bloc")
    public void deleteBloc(@RequestBody Long bId) {
        blocService.deleteBloc(bId);
    }

    @PostMapping("/affecterBlocAFoyer")
    public  Bloc affecterBlocAFoyer(@RequestParam String nomBloc, @RequestParam Foyer foyer) {
        return blocService.affecterBlocAFoyer(nomBloc, foyer);
    }


}
