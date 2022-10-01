package com.misiontic.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "audience")
public class Audience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String owner;

    @Getter
    @Setter
    private Integer capacity;

    //! Error Critico a la hora de enlazar 
    //! Las llaves foraneas
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("audiences")
    @Getter
    @Setter
    private Category category;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "idMessage", nullable = true)
    @JsonIgnoreProperties("audience")
    private Message message;

    @ManyToOne
    @JoinColumn(name = "idAudience")
    @JsonIgnoreProperties("audience")
    @Getter
    @Setter
    private Reservation reservation;

}