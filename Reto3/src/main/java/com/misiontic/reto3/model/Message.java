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

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "message")
    @JsonIgnoreProperties("messages")
    @Getter
    @Setter
    private List<Audience> audiences;
}
