package com.example.UNIT_2_Esercizio_S6_L5.model;

import com.example.UNIT_2_Esercizio_S6_L5.enums.TipoDispositivo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Dispositivo {
	@Id
	@GeneratedValue
	private int id;
	private String dispositivo;

	@Column(name = "stato_dispositivi")
	@Enumerated(EnumType.STRING)
	private TipoDispositivo statoDispositivo;

	@ManyToOne
	@JoinColumn(name = "dipendente_id")
	@JsonBackReference
	private Dipendente dipendente;

}
