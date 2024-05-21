package epicode.it.UNIT2EsercizioS6L2.controller;

import epicode.it.UNIT2EsercizioS6L2.exception.BlogNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.model.Blog;
import epicode.it.UNIT2EsercizioS6L2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@GetMapping
	public List<Blog> getAll() {
		return blogService.getAll();
	}

	@PostMapping
	public String saveBlog(@RequestBody Blog blog) {
		return blogService.save(blog);
	}

	@GetMapping("/{id}")
	public Blog getStudenteByMatricola(@PathVariable int id) throws BlogNonTrovatoException {
		Optional<Blog> blogOpt = blogService.getById(id);

		if (blogOpt.isPresent()) {
			return blogOpt.get();
		} else {
			throw new BlogNonTrovatoException("blog con id " + id + " non trovato");
		}
	}

	@PutMapping("/{id}")
	public Blog updateBlog(@PathVariable int id, @RequestBody Blog updatedBlog) throws BlogNonTrovatoException {
		return blogService.update(id, updatedBlog);
	}

	@DeleteMapping("/{id}")
	public void deleteBlog(@PathVariable int id) throws BlogNonTrovatoException {
		blogService.delete(id);
	}
}
