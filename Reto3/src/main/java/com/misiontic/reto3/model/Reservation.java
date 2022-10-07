package com.misiontic.reto3.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

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

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "audienceId")
    @JsonIgnoreProperties({ "reservations", "messages" })
    private Audience audience;

    @Getter
    @Setter
    @ManyToOne
    @JsonIgnoreProperties("reservations")
    @JoinColumn(name = "idClient")
    private Client client;

    @Getter
    @Setter
    private Integer score;

    // @Getter
    // @Setter
    // @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "reservation")
    // @JsonIgnoreProperties("reservatiom")
    // private List<Category> categories;
}
