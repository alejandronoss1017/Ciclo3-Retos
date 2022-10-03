package com.usa.proyectoa.poyectoa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String messageText;

    @ManyToOne
    @JoinColumn (name = "client")
    @JsonIgnoreProperties("messages")
    private Client client;

    public Integer getId (){
        return id;
    }

    public void setId (Integer id){
        this.id = id;
    }

    public String getMessageText (){
        return messageText;
    }

    public void setMessageText (String messageText){
        this.messageText = messageText;
    }

    public Client getClient (){
        return client;
    }

    public void setClient (Client client){
        this.client = client;
    }
}