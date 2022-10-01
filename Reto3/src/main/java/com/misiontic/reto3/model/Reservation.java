package com.misiontic.reto3.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    @Setter
    private Integer idReservation;

    @Getter
    @Setter
    private Date startDate;

    @Getter
    @Setter
    private Date devolutionDate;

    @Getter
    @Setter
    private String status;

    @ManyToOne
    @JsonIgnoreProperties("reservation")
    @Getter
    @Setter
    private Audience audience;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties("reservations")
    @Getter
    @Setter
    private Client client;


    // @ManyToOne
    // @JoinColumn(name = "idCategory")
    // @JsonIgnoreProperties("reservation")
    // @Getter
    // @Setter
    // private Category category;
}
