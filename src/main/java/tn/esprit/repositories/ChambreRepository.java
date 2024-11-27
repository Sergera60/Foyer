package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Bloc;
import tn.esprit.entities.Chambre;

import java.util.Date;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

 List<Chambre> findByBloc_NomBloc(String nomBloc);
 List<Chambre> findByReservations_AnneeUniversitaireBetween(Date d1, Date d2);

 Integer countByBloc_Foyer_CapaciteFoyerLessThan(Long capaciteFoyer);


 @Query("select c from Chambre c where c.bloc.nomBloc  = ?1")
List<Chambre> chambresSelonNomBloc( String nomBloc);

 Chambre findByNumChambre (Long numChambre);



 @Query( "select c from Chambre c  join c.reservations r where r.anneeUniversitaire between :d1 and :d2")
 List<Chambre> ReservationAnneUniversitaire(@Param("d1") Date d1, @Param("d2") Date d2);



 Integer countByReservations_EstValideFalseAndReservations_AnneeUniversitaireBefore(Date anneeUniversitaire);

 @Query("SELECT COUNT(c) FROM Chambre c JOIN c.reservations r WHERE r.estValide = false AND r.anneeUniversitaire < :anneeUniversitaire")
 Integer countChambresReservationsNonValides(@Param("anneeUniversitaire") Date anneeUniversitaire);








}
