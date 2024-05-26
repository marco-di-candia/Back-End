package com.example.UNIT_2_Esercizio_S6_L5.service;

import com.example.UNIT_2_Esercizio_S6_L5.DTO.DtoDispositivo;
import com.example.UNIT_2_Esercizio_S6_L5.exception.NotFoundException;
import com.example.UNIT_2_Esercizio_S6_L5.model.Dispositivo;
import com.example.UNIT_2_Esercizio_S6_L5.model.Dipendente;
import com.example.UNIT_2_Esercizio_S6_L5.repository.RepositoryDispositivo;
import com.example.UNIT_2_Esercizio_S6_L5.repository.RepositoryDipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDispositivo {

	@Autowired
	private RepositoryDispositivo dispositivoR;

	@Autowired
	private RepositoryDipendente dipendenteR;

	public String save(DtoDispositivo dtoDispositivo) {
		Optional<Dipendente> dipendenteOptional = dipendenteR.findById(dtoDispositivo.getDipendenteId());

		if (dipendenteOptional.isPresent()) {
			Dipendente dipendente = dipendenteOptional.get();
			Dispositivo d = new Dispositivo();
			d.setDispositivo(dtoDispositivo.getDispositivo());
			d.setStatoDispositivo(dtoDispositivo.getStatoDispositivo());
			d.setDipendente(dipendente);

			dispositivoR.save(d);
			return "Dispositivo con id=" + d.getId() + " creato con successo e associato al dipendente con id=" + dipendente.getId();
		} else {
			throw new NotFoundException("Dipendente con id=" + dtoDispositivo.getDipendenteId() + " non trovato");
		}
	}

	public List<Dispositivo> getAll() {
		return dispositivoR.findAll();
	}

	public Optional<Dispositivo> getById(int id) {
		return dispositivoR.findById(id);
	}

	public Dispositivo update(int id, DtoDispositivo dtoDispositivo) {
		Optional<Dispositivo> dispositivoOptional = getById(id);

		if (dispositivoOptional.isPresent()) {
			Dispositivo d = dispositivoOptional.get();
			d.setDispositivo(dtoDispositivo.getDispositivo());
			d.setStatoDispositivo(dtoDispositivo.getStatoDispositivo());

			Optional<Dipendente> dipendenteOptional = dipendenteR.findById(dtoDispositivo.getDipendenteId());
			if (dipendenteOptional.isPresent()) {
				Dipendente dipendente = dipendenteOptional.get();
				d.setDipendente(dipendente);
			} else {
				throw new NotFoundException("Dipendente con id=" + dtoDispositivo.getDipendenteId() + " non trovato");
			}

			return dispositivoR.save(d);
		} else {
			throw new NotFoundException("Dispositivo con id=" + id + " non trovato");
		}
	}

	public String delete(int id) {
		Optional<Dispositivo> dispositivoOptional = getById(id);

		if (dispositivoOptional.isPresent()) {
			dispositivoR.delete(dispositivoOptional.get());
			return "Dispositivo con id=" + id + " cancellato con successo";
		} else {
			throw new NotFoundException("Dispositivo con id=" + id + " non trovato");
		}
	}
}
