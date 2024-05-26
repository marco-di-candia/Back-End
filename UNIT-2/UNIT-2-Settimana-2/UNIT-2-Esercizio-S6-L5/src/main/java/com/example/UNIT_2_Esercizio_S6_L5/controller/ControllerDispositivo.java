package com.example.UNIT_2_Esercizio_S6_L5.controller;

import com.example.UNIT_2_Esercizio_S6_L5.DTO.DtoDispositivo;
import com.example.UNIT_2_Esercizio_S6_L5.exception.NotFoundException;
import com.example.UNIT_2_Esercizio_S6_L5.model.Dispositivo;
import com.example.UNIT_2_Esercizio_S6_L5.service.ServiceDispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dispositivo")
public class ControllerDispositivo {

	@Autowired
	private ServiceDispositivo serviceDispositivo;

	@GetMapping
	public List<Dispositivo> getAll() {
		return serviceDispositivo.getAll();
	}

	@PostMapping
	public String save(@RequestBody DtoDispositivo dtoDispositivo) {
		return serviceDispositivo.save(dtoDispositivo);
	}

	@GetMapping("/{id}")
	public Dispositivo getById(@PathVariable("id") int id){
		Optional<Dispositivo> autoreOptional = serviceDispositivo.getById(id);

		if (autoreOptional.isPresent()) {
			return autoreOptional.get();
		} else {
			throw new NotFoundException("Autore con id=" + id + " non trovato");
		}
	}

	@PutMapping("/{id}")
	public Dispositivo update(@PathVariable("id") int id, @RequestBody DtoDispositivo dtoDispositivo) {
		return serviceDispositivo.update(id, dtoDispositivo);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id){
		return serviceDispositivo.delete(id);
	}

}
