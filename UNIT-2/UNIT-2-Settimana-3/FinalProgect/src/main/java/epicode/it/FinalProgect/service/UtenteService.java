package epicode.it.FinalProgect.service;

import epicode.it.FinalProgect.Dto.UtenteDto;
import epicode.it.FinalProgect.enums.RuoloUtente;
import epicode.it.FinalProgect.exceptions.BadRequestException;
import epicode.it.FinalProgect.exceptions.NotFoundException;
import epicode.it.FinalProgect.model.Utente;
import epicode.it.FinalProgect.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Optional<Utente> getDipendenteByUsername(int username){
		return utenteRepository.findById(username);
	}
	public String saveUtente(UtenteDto utenteDto) {
		if (getUtenteByEmail(utenteDto.getEmail()).isEmpty()) {
			Utente utente = new Utente();
			utente.setNome(utenteDto.getNome());
			utente.setCognome(utenteDto.getCognome());
			utente.setEmail(utenteDto.getEmail());
			utente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));
			utente.setRuoloUtente(RuoloUtente.UTENTE_NORMALE);

			utenteRepository.save(utente);
			return "Utente con id " + utente.getId() + " salvato correttamente";
		} else {
			throw new BadRequestException("L'email dell'utente " + utenteDto.getEmail() + " è già presente");
		}
	}

	public List<Utente> getUtenti() {
		return utenteRepository.findAll();
	}

	public Optional<Utente> getUtenteById(Integer id) {
		return utenteRepository.findById(id);
	}

	public Utente updateUtente(Integer id, UtenteDto utenteDto) {
		Optional<Utente> utenteOptional = getUtenteById(id);
		if (utenteOptional.isPresent()) {
			Utente utente = utenteOptional.get();
			utente.setNome(utenteDto.getNome());
			utente.setCognome(utenteDto.getCognome());
			utente.setEmail(utenteDto.getEmail());
			utente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));
			return utenteRepository.save(utente);
		} else {
			throw new NotFoundException("Utente con id " + id + " non trovato");
		}
	}

	public String deleteUtente(Integer id) {
		Optional<Utente> utenteOptional = getUtenteById(id);
		if (utenteOptional.isPresent()) {
			utenteRepository.delete(utenteOptional.get());
			return "Utente con id " + id + " cancellato con successo";
		} else {
			throw new NotFoundException("Utente con id " + id + " non trovato");
		}
	}

	public Optional<Utente> getUtenteByEmail(String email) {
		return utenteRepository.findByEmail(email);
	}
}
