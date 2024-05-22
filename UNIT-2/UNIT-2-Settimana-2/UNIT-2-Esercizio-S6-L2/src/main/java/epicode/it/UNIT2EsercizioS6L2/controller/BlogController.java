package epicode.it.UNIT2EsercizioS6L2.controller;

import epicode.it.UNIT2EsercizioS6L2.Dto.BlogDto;
import epicode.it.UNIT2EsercizioS6L2.model.Blog;
import epicode.it.UNIT2EsercizioS6L2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@GetMapping
	public Page<Blog> getAllblogs(@RequestParam(defaultValue = "0") int page,
								  @RequestParam(defaultValue = "15") int size,
								  @RequestParam(defaultValue = "matricola") String sortBy){

		return blogService.getblogs(page, size, sortBy);
	}


	@PostMapping
	public ResponseEntity<String> saveBlog(@RequestBody BlogDto blogDto) {
		String response = blogService.saveBlog(blogDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable int id) {
		Optional<Blog> blogOptional = blogService.getBlogById(id);
		return blogOptional.map(blog -> new ResponseEntity<>(blog, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}


	@PutMapping("/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable int id, @RequestBody BlogDto blogDto) {
		Blog updatedBlog = blogService.updateBlog(id, blogDto);
		return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBlog(@PathVariable int id) {
		String response = blogService.deleteBlog(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}

