package com.misiontic.reto3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String name;
    
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Audience> audiences;

    // @ManyToOne
    // @JoinColumn(name = "idReservation")
    // @JsonIgnoreProperties("category")
    // @Getter
    // @Setter
    // private Reservation reservation;

}
