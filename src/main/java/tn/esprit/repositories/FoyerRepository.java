package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Foyer;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {



@Query("SELECT f FROM Foyer f join f.blocs b join b.chambres c WHERE c.numChambre in ?1")
    Foyer findFoyerByNumChambre(List<Long> numChambres);


Foyer findByBlocs_Chambres_NumChambreIn(List<Long> numChambres);


}
