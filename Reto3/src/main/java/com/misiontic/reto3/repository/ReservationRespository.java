package com.misiontic.reto3.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.misiontic.reto3.model.Client;
import com.misiontic.reto3.model.Reservation;
import com.misiontic.reto3.model.DTO.TotalAndClient;
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

    // Reto 5

    public List<Reservation> getReservationsBetweenDates(Date startDate, Date devolutionDate) {
        return reservationCrudRepositoy.findAllByStartDateAfterAndDevolutionDateBefore(startDate, devolutionDate);
    }

    public List<Reservation> findAllByStatus(String status) {
        return reservationCrudRepositoy.findAllByStatus(status);
    }

    public List<TotalAndClient> getTopClients() {
        List<TotalAndClient> aswer = new ArrayList<>();
        List<Object[]> report = reservationCrudRepositoy.getTotalReservationsByClient();

        for (int i = 0; i < report.size(); i++) {
            aswer.add(new TotalAndClient((Integer) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return aswer;

    }

}
