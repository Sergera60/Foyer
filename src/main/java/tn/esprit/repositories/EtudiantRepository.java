package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Etudiant;

import java.util.Date;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<String> findDistinctNomEtByReservationsEstValideTrueAndReservationsAnneeUniversitaire(Date anneeUniversitaire);

    @Query("SELECT e.nomEt FROM Etudiant e JOIN e.reservations r WHERE r.estValide = true AND FUNCTION('YEAR', r.anneeUniversitaire) = :currentYear")
    List<String> findNomEtudiantByReservationValideAndAnneeUniversitaire(@Param("currentYear") Date currentYear);
}
