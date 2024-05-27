package com.example.UNIT_2_Esercizio_S6_L5.repository;

import com.example.UNIT_2_Esercizio_S6_L5.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryDipendente extends JpaRepository<Dipendente, Integer> {
	public Optional<Dipendente> findByEmail(String email);
}
