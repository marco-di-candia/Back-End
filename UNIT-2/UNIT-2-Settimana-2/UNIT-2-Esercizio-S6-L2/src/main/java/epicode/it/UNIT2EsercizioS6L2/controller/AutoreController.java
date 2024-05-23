package epicode.it.UNIT2EsercizioS6L2.controller;

import epicode.it.UNIT2EsercizioS6L2.Dto.AutoreDto;
import epicode.it.UNIT2EsercizioS6L2.exception.AutoreNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.model.Autore;
import epicode.it.UNIT2EsercizioS6L2.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autore")
public class AutoreController {

	@Autowired
	private AutoreService autoreService;

	@GetMapping
	public List<Autore> getAll() {
		return autoreService.getAll();
	}

	@PostMapping
	public String save(@RequestBody AutoreDto autoreDto) {
		return autoreService.save(autoreDto);
	}

	@GetMapping("/{id}") // Specify the path variable name
	public Autore getById(@PathVariable("id") int id) throws AutoreNonTrovatoException {
		Optional<Autore> autoreOptional = autoreService.getById(id);

		if (autoreOptional.isPresent()) {
			return autoreOptional.get();
		} else {
			throw new AutoreNonTrovatoException("Autore con id=" + id + " non trovato");
		}
	}

	@PutMapping("/{id}")
	public Autore update(@PathVariable("id") int id, @RequestBody AutoreDto autoreDto) throws AutoreNonTrovatoException {
		return autoreService.update(id, autoreDto);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) throws AutoreNonTrovatoException {
		return autoreService.delete(id);
	}
	@PatchMapping("/{id}")
	public String patchAvatar(@RequestBody MultipartFile avatar,@PathVariable int id) throws AutoreNonTrovatoException, IOException {
		return autoreService.patchAvatar(id,avatar);
	}
}
