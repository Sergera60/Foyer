package tn.esprit.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.entities.CoursClassroom;
import tn.esprit.entities.Niveau;
import tn.esprit.entities.Specialite;
import tn.esprit.services.ICourClassroomService;


@RestController
@AllArgsConstructor
@RequestMapping("/CourClassroom")

public class CourClassroomController {

   ICourClassroomService coursC ;
    @PostMapping("/add-CourClassroom")
    public CoursClassroom addClassroom(CoursClassroom coursClassroom, Integer codeClasse){

        CoursClassroom coursClassroom1 =coursC.ajouterCoursClassroom(coursClassroom, codeClasse) ;
        return coursClassroom1 ;
    }

    @PostMapping("/desaffecterCoursClassroom")
    public void desaffecterCoursClassroom(Integer idCoursClassroom){

        coursC.desafeecterCoursClassroomClasse(idCoursClassroom);
    }

    @GetMapping("/nbHeureParSpecCour")
    public Integer nbHeureParSpecCour(Specialite spec, Niveau niv) {

        return coursC.nbHeureParSpecEtNiv(spec, niv);
    }


}
