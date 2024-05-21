package epicode.it.UNIT2EsercizioS6L2.controller;

import epicode.it.UNIT2EsercizioS6L2.exception.AutoreNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.exception.BlogNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.model.Autore;
import epicode.it.UNIT2EsercizioS6L2.model.Blog;
import epicode.it.UNIT2EsercizioS6L2.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public String saveBlog(@RequestBody Autore autore) {
		return autoreService.save(autore);
	}

	@GetMapping("/{id}")
	public Autore getStudenteByMatricola(@PathVariable int id) throws AutoreNonTrovatoException {
		Optional<Autore> blogOpt = autoreService.getById(id);

		if (blogOpt.isPresent()) {
			return blogOpt.get();
		} else {
			throw new AutoreNonTrovatoException("autore con id " + id + " non trovato");
		}
	}

	@PutMapping("/{id}")
	public Autore updateBlog(@PathVariable int id, @RequestBody Autore updatedBlog) throws AutoreNonTrovatoException {
		return autoreService.update(id, updatedBlog);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) throws AutoreNonTrovatoException {
		autoreService.delete(id);
	}
}
