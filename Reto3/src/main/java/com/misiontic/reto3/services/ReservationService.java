package com.misiontic.reto3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misiontic.reto3.repository.ReservationRespository;
import com.misiontic.reto3.model.Reservation;

@Service
public class ReservationService {
    @Autowired
    private ReservationRespository reservationRespository;

    public List<Reservation> getAll() {
        return reservationRespository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRespository.getReservation(id);
    }

    public Reservation save(Reservation p) {
        if (p.getIdReservation() == null) {
            return reservationRespository.save(p);
        } else {
            Optional<Reservation> e = reservationRespository.getReservation(p.getIdReservation());
            if (e.isPresent()) {

                return p;
            } else {
                return reservationRespository.save(p);
            }
        }
    }

    public Reservation update(Reservation p) {
        if (p.getIdReservation() != null)

        {
            Optional<Reservation> q = reservationRespository.getReservation(p.getIdReservation());
            if (q.isPresent()) {
                if (p.getIdReservation() != null) {
                    q.get().setIdReservation(p.getIdReservation());
                }
                if (p.getClient() != null) {
                    q.get().setClient(p.getClient());
                }
                if (p.getStartDate() != null) {
                    q.get().setStartDate(p.getStartDate());
                }
                if (p.getDevolutionDate() != null) {
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                reservationRespository.save(q.get());
                return q.get();
            } else {
                return p;
            }
        } else {
            return p;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Reservation> p = reservationRespository.getReservation(id);
        if (p.isPresent()) {
            reservationRespository.delete(p.get());
            flag = true;
        }
        return flag;

    }
}
