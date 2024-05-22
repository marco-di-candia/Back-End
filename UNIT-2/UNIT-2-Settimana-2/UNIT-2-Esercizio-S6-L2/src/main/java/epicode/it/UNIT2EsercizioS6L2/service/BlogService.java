package epicode.it.UNIT2EsercizioS6L2.service;

import epicode.it.UNIT2EsercizioS6L2.Dto.BlogDto;
import epicode.it.UNIT2EsercizioS6L2.exception.AutoreNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.exception.BlogNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.model.Autore;
import epicode.it.UNIT2EsercizioS6L2.model.Blog;
import epicode.it.UNIT2EsercizioS6L2.repository.AutoreRepository;
import epicode.it.UNIT2EsercizioS6L2.repository.BlogRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class BlogService {

	@Autowired
	private AutoreRepository autoreRepository;

	@Autowired
	private BlogRepository blogRepository;

	@SneakyThrows
	public String saveBlog(BlogDto blogDto) {
		Optional<Autore> autoreOptional = autoreRepository.findById(blogDto.getId_autore());

		if (autoreOptional.isPresent()) {
			Autore autore = autoreOptional.get();
			Blog blog = new Blog();
			blog.setCategoria(blogDto.getCategoria());
			blog.setTitolo(blogDto.getTitolo());
			blog.setCover(blogDto.getCover());
			blog.setContenuto(blogDto.getContenuto());
			blog.setTempo_di_lettura(blogDto.getTempo_di_lettura());
			blog.setAutore(autore);
			blogRepository.save(blog);
			return "Blog con id=" + blog.getId() + " salvato correttamente";
		} else {
			throw new AutoreNonTrovatoException("Autore con id=" + blogDto.getId_autore() + " non trovato");
		}
	}

	public Page<Blog> getblogs(int page, int size, String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return blogRepository.findAll(pageable);
	}

	public Optional<Blog> getBlogById(int id) {
		return blogRepository.findById(id);
	}

	@SneakyThrows
	public Blog updateBlog(int id, BlogDto blogDto) {
		Optional<Blog> blogOptional = getBlogById(id);

		if (blogOptional.isPresent()) {
			Blog blog = blogOptional.get();
			blog.setCategoria(blogDto.getCategoria());
			blog.setTitolo(blogDto.getTitolo());
			blog.setCover(blogDto.getCover());
			blog.setContenuto(blogDto.getContenuto());
			blog.setTempo_di_lettura(blogDto.getTempo_di_lettura());
			return blogRepository.save(blog);
		} else {
			throw new BlogNonTrovatoException("Blog con id=" + id + " non trovato");
		}
	}

	@SneakyThrows
	public String deleteBlog(int id) {
		Optional<Blog> blogOptional = getBlogById(id);

		if (blogOptional.isPresent()) {
			blogRepository.delete(blogOptional.get());
			return "Blog con id=" + id + " cancellato con successo";
		} else {
			throw new BlogNonTrovatoException("Blog con id=" + id + " non trovato");
		}
	}
}
