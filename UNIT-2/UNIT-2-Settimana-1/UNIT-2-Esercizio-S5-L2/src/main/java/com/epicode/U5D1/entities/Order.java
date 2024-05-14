package com.epicode.U5D1.entities;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class Order {
	private int numeroOrdine;
	private StatoOrdine statoOrdine;
	private int numeroCoperti;
	private LocalTime oraAquisizione;
	private static final double COSTO_COPERTI = 5.0;
	private double prezzoTotale;
	private List<Item> menuItem;

	public double getSomma(){
		double somma = 0;
		for (Item item : menuItem){
			somma += item.getPrice();
		}
		somma+= getNumeroCoperti() * COSTO_COPERTI;
		return somma;
	}
}
