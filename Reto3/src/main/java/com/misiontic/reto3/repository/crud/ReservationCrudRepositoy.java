package com.misiontic.reto3.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.misiontic.reto3.model.Reservation;

public interface ReservationCrudRepositoy extends CrudRepository<Reservation, Integer> {

    /**
     * Reporte 1
     * 
     * SELECT *
     * FROM Reservation
     * Where startDate AFTER startDate AND devolutionDate BEFORE fechaB
     */

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date startDate, Date devolutionDate);

    /**
     * Reporte 2
     * 
     * SELECT COUNT(*)
     * FROM Reservation
     * WHERE status = "completed" OR status = "cancelled"
     * GROUP BY;
     */

    public List<Reservation> findAllByStatus(String status);

    /**
     * Reporte 3
     * 
     * SELECT COUNT(client), client
     * FROM Reservation
     * GROUP BT client
     * ORDER BY COUNT(client) DESC;
     */

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY COUNT(c.client)")
    public List<Object[]> getTotalReservationsByClient();
}
