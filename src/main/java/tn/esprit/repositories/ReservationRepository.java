package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {



}
