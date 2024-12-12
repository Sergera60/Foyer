package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Classe;
import tn.esprit.entities.CoursClassroom;
import tn.esprit.entities.Niveau;
import tn.esprit.entities.Specialite;
import tn.esprit.repositories.ClasseRepository;
import tn.esprit.repositories.CourClassroomRepository;


@Service
@AllArgsConstructor
public class CourClassroomsServiceImpl implements  ICourClassroomService {

CourClassroomRepository courClassroomRepository;

CourClassroomRepository courClass;
ClasseRepository classe;

    @Override
    public CoursClassroom ajouterCoursClassroom(CoursClassroom cc, Integer codeClasse) {
        Classe clas = classe.findById(codeClasse).get();
        cc.setClasse(clas);
        return courClass.save(cc);
    }

    @Override
    public void desafeecterCoursClassroomClasse(Integer idCours) {
        CoursClassroom cc = courClassroomRepository.findById(idCours).get();

        cc.setClasse(null);
        courClassroomRepository.save(cc);

    }

    @Override
    public Integer nbHeureParSpecEtNiv(Specialite spec, Niveau nv) {
        return courClassroomRepository.findByNbHoursBySpecialiteAndClasse_Niveau(spec,nv);
    }


}
