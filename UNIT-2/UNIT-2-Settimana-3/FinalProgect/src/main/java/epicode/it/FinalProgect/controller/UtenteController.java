package epicode.it.FinalProgect.controller;

import epicode.it.FinalProgect.Dto.UtenteDto;
import epicode.it.FinalProgect.exceptions.BadRequestException;
import epicode.it.FinalProgect.exceptions.NotFoundException;
import epicode.it.FinalProgect.model.Utente;
import epicode.it.FinalProgect.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UtenteController {
	@Autowired
	private UtenteService utenteService;

	@GetMapping("/api/utenti")
	@PreAuthorize("hasAnyAuthority('UTENTE_NORMALE', 'ORGANIZZATORE_DI_EVENTI')")
	public List<Utente> getUtenti(){
		return utenteService.getUtenti();
	}

	@GetMapping("/api/utenti/{id}")
	@PreAuthorize("hasAnyAuthority('UTENTE_NORMALE', 'ORGANIZZATORE_DI_EVENTI')")
	public Utente getUtenteById(@PathVariable Integer id) {
		Optional<Utente> utenteOptional = utenteService.getUtenteById(id);
		if (utenteOptional.isPresent()) {
			return utenteOptional.get();
		} else {
			throw new NotFoundException("Utente con id " + id + " non trovato");
		}
	}

	@PostMapping("/api/utenti")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ORGANIZZATORE_DI_EVENTI')")
	public String saveUtente(@RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", String::concat));
		}
		return utenteService.saveUtente(utenteDto);
	}

	@PutMapping("/api/utenti/{id}")
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('ORGANIZZATORE_DI_EVENTI')")
	public Utente updateUtente(@PathVariable Integer id, @RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new BadRequestException(bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).reduce("", String::concat));
		}
		return utenteService.updateUtente(id, utenteDto);
	}

	@DeleteMapping("/api/utenti/{id}")
	@PreAuthorize("hasAuthority('ORGANIZZATORE_DI_EVENTI')")
	public String deleteUtente(@PathVariable Integer id) {
		if (utenteService.getUtenteById(id).isPresent()) {
			return utenteService.deleteUtente(id);
		} else {
			throw new NotFoundException("Utente con id " + id + " non trovato");
		}
	}
}
