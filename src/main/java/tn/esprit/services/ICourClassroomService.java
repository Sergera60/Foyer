package tn.esprit.services;


import tn.esprit.entities.CoursClassroom;
import tn.esprit.entities.Niveau;
import tn.esprit.entities.Specialite;

public interface ICourClassroomService {


    CoursClassroom ajouterCoursClassroom(CoursClassroom cc , Integer codeClasse);

    void desafeecterCoursClassroomClasse(Integer idCours);

    Integer nbHeureParSpecEtNiv(Specialite spec , Niveau nv);



}
