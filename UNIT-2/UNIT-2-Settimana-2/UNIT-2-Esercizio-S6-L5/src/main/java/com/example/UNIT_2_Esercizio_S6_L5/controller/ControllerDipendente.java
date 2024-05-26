package com.example.UNIT_2_Esercizio_S6_L5.controller;

import com.example.UNIT_2_Esercizio_S6_L5.DTO.DtoDipendente;
import com.example.UNIT_2_Esercizio_S6_L5.exception.NotFoundException;
import com.example.UNIT_2_Esercizio_S6_L5.model.Dipendente;
import com.example.UNIT_2_Esercizio_S6_L5.service.ServiceDipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dipendente")
public class ControllerDipendente {

	@Autowired
	private ServiceDipendente serviceDipendente;

	@GetMapping
	public List<Dipendente> getAll(@RequestParam(defaultValue = "0") int page,
								   @RequestParam(defaultValue = "10") int size,
								   @RequestParam(defaultValue = "id") String sortBy) {
		return serviceDipendente.getAll(page, size, sortBy).getContent();
	}


	@PostMapping
	public String save(@RequestBody DtoDipendente dtoDipendente) {
		return serviceDipendente.save(dtoDipendente);
	}

	@GetMapping("/{id}")
	public Dipendente getById(@PathVariable("id") int id){
		Optional<Dipendente> dipendenteOptional = serviceDipendente.getById(id);

		if (dipendenteOptional.isPresent()) {
			return dipendenteOptional.get();
		} else {
			throw new NotFoundException("Dipendente con id=" + id + " non trovato");
		}
	}

	@PutMapping("/{id}")
	public Dipendente update(@PathVariable("id") int id, @RequestBody DtoDipendente dtoDipendente) {
		return serviceDipendente.update(id, dtoDipendente);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id){
		return serviceDipendente.delete(id);
	}

	@PatchMapping("/{id}")
	public String patchAvatar(@RequestBody MultipartFile avatar, @PathVariable int id) throws IOException {
		return serviceDipendente.patchAvatar(id,avatar);
	}
}
