package com.misiontic.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

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
    private String name;

    @Getter
    @Setter
    private String owner;

    @Getter
    @Setter
    private Integer capacity;

    @Getter
    @Setter
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("audiences")
    @Getter
    @Setter
    private Category category;

    @Getter
    @Setter
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "audience")
    @JsonIgnoreProperties("audience")
    private List<Message> messages;

    @Getter
    @Setter
    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "audience")
    @JsonIgnoreProperties("audience")
    private List<Reservation> reservations;

}