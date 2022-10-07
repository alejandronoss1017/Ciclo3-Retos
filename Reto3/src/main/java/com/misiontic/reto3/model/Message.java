package com.misiontic.reto3.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;

    @Getter
    @Setter
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "audienceId")
    @JsonIgnoreProperties({ "messages", "reservations" })
    @Getter
    @Setter
    private Audience audience;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({ "messages", "reservations" })
    @Getter
    @Setter
    private Client client;
}
