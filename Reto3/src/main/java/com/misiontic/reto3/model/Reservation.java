package com.misiontic.reto3.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    
    private Integer idReservation;
    private Date beginDate;
    private Date endDate;
    private String client;
}
