package com.misiontic.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.misiontic.reto3.model.Reservation;
import com.misiontic.reto3.repository.crud.ReservationCrudRepositoy;

@Repository
public class ReservationRespository {
    @Autowired
    private ReservationCrudRepositoy reservationCrudRepositoy;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepositoy.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepositoy.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRepositoy.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationCrudRepositoy.delete(reservation);
    }
}
