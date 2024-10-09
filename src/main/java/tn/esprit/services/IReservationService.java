package tn.esprit.services;

import tn.esprit.entities.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(String id);

    Reservation getReservationById(String id);

    List<Reservation> allReservations();

}
