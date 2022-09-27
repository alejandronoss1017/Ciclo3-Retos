package com.misiontic.reto3.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	
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
	@Getter
	@Setter
	private Integer categoryId;
	@Getter
	@Setter
	private String name;

	public Client(Integer id, String owner, Integer capacity, Integer categoryId, String name) {
		this.id = id;
		this.owner = owner;
		this.capacity = capacity;
		this.categoryId = categoryId;
		this.name = name;
	}
}
