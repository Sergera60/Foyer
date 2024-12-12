package tn.esprit.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.CoursClassroom;
import tn.esprit.entities.Niveau;
import tn.esprit.entities.Specialite;


@Repository
public interface CourClassroomRepository extends JpaRepository<CoursClassroom, Integer> {

    //find in classrom nbhorus by specailité in classrom  and niveau in classe its find not count using query
    Integer findCoursClassroom_NbHoursBySpecialiteAndClasse_Niveau(Specialite spec, Niveau nv);







}
