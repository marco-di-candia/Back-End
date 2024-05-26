package com.example.UNIT_2_Esercizio_S6_L5.service;

import com.cloudinary.Cloudinary;
import com.example.UNIT_2_Esercizio_S6_L5.DTO.DtoDipendente;
import com.example.UNIT_2_Esercizio_S6_L5.exception.NotFoundException;
import com.example.UNIT_2_Esercizio_S6_L5.model.Dipendente;
import com.example.UNIT_2_Esercizio_S6_L5.repository.RepositoryDipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
public class ServiceDipendente {

	@Autowired
	private RepositoryDipendente dipendenteR;

	@Autowired
	private Cloudinary cloudinary;

	private final String AVATAR_API = "https://ui-avatars.com/api/?name=";

	public String save(DtoDipendente dtoDipendente) {
		Dipendente dipendente = new Dipendente();
		dipendente.setNome(dtoDipendente.getNome());
		dipendente.setCognome(dtoDipendente.getCognome());
		String avatarUrl = generateAvatarUrl(dipendente.getNome(), dipendente.getCognome());
		dipendente.setAvatar(avatarUrl);
		dipendente.setEmail(dtoDipendente.getEmail());
		dipendente.setUsername(dtoDipendente.getCognome());
		dipendenteR.save(dipendente);
		return "Dipendente con id=" + dipendente.getId() + " salvato correttamente";

	}

	private String generateAvatarUrl(String nome, String cognome) {
		String fullName = nome + "+" + cognome;
		return AVATAR_API + fullName;
	}

	public Page<Dipendente> getAll(int page, int size, String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return dipendenteR.findAll(pageable);
	}

	public Optional<Dipendente> getById(int id) {
		return dipendenteR.findById(id);
	}

	public Dipendente update(int id, DtoDipendente dtoDipendente) {
		Optional<Dipendente> dOptional = getById(id);

		if (dOptional.isPresent()) {
			Dipendente d = dOptional.get();
			d.setNome(dtoDipendente.getNome());
			d.setCognome(dtoDipendente.getCognome());
			d.setEmail(dtoDipendente.getEmail());
			d.setUsername(dtoDipendente.getCognome());

			return dipendenteR.save(d);
		} else {
			throw new NotFoundException("Dipendente con id=" + id + " non trovato");
		}
	}

	public String delete(int id) {
		Optional<Dipendente> dipendenteOptional = getById(id);

		if (dipendenteOptional.isPresent()) {
			dipendenteR.delete(dipendenteOptional.get());
			return "Dipendente con id=" + id + " cancellato con successo";
		} else {
			throw new NotFoundException("Dipendente con id=" + id + " non trovato");
		}
	}

	public String patchAvatar(int matricola, MultipartFile avatar) throws IOException {
		Optional<Dipendente> studenteOptional = getById(matricola);

		if (studenteOptional.isPresent()) {
			String url = (String) cloudinary.uploader().upload(avatar.getBytes(), Collections.emptyMap()).get("url");
			Dipendente dipendente = studenteOptional.get();
			dipendente.setAvatar(url);
			dipendenteR.save(dipendente);
			return "Studente con matricola=" + matricola + " aggiornato correttamente con la foto inviata";
		} else {
			throw new NotFoundException("autore con matricola=" + matricola + " non trovato");
		}
	}
}
