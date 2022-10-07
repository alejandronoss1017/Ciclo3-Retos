package com.misiontic.reto3.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Getter
	@Setter
	private Integer idClient;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private Integer age;

	@Getter
	@Setter
	@OneToMany
	@JoinColumn(name = "idMessage")
	@JsonIgnoreProperties("client")
	private List<Message> messages;

	@Getter
	@Setter
	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "client")
	@JsonIgnoreProperties("client")
	private List<Reservation> reservations;
}
