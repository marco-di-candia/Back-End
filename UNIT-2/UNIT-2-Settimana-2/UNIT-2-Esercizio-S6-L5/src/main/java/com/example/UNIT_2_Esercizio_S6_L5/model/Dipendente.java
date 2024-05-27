package com.example.UNIT_2_Esercizio_S6_L5.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Dipendente {
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String cognome;
	private String username;
	private String email;
	private String password;
	@OneToMany(mappedBy = "dipendente")
	@JsonManagedReference
	private List<Dispositivo> dispositivi;

	private String avatar;
}
