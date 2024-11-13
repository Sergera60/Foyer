package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Foyer;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {
    List<Foyer> findDistinctByNumChambreIn(List<Integer> numChambres);

    @Query("SELECT DISTINCT b.foyer FROM Chambre c JOIN c.bloc b WHERE c.numChambre IN :numChambres")
    List<Foyer> findFoyersByNumChambres(@Param("numChambres") List<Long> numChambres);


}
