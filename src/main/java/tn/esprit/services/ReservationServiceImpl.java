package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Etudiant;
import tn.esprit.entities.Reservation;
import tn.esprit.repositories.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository res;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return res.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return res.save(reservation);
    }

    @Override
    public void deleteReservation(String id) {
        res.deleteById(id);

    }

    @Override
    public Reservation getReservationById(String id) {
        return res.findById(id).get();
    }

    @Override
    public List<Reservation> allReservations() {
        return res.findAll();
    }

    @Override
    public Reservation ajouterReservationAvecEtudiants(Reservation reservation) {
        Reservation reservation1 = res.save(reservation);
        List<Etudiant> et = reservation1.getEtudiants();

    reservation1.setEtudiants(et);
        return res.save(reservation1);
    }
}
