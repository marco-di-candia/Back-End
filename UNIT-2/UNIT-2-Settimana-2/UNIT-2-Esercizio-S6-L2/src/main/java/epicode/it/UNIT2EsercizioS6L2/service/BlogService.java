package epicode.it.UNIT2EsercizioS6L2.service;

import epicode.it.UNIT2EsercizioS6L2.exception.BlogNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
	private List<Blog> blogs = new ArrayList<>();

	public List<Blog> getAll() {
		return blogs;
	}

	public String save(Blog blog) {
		blogs.add(blog);
		return "blog Creato" + " " + blog.getId();
	}

	public Optional<Blog> getById(int id) {
		return blogs.stream().filter(blog -> blog.getId() == id).findFirst();
	}

	public Blog update(int id, Blog blog) throws BlogNonTrovatoException {
		Optional<Blog> blogOpt = getById(id);
		if (blogOpt.isPresent()) {
			Blog blog1 = blogOpt.get();
			blog1.setCategoria(blog.getCategoria());
			blog1.setContenuto(blog.getContenuto());
			blog1.setTitolo(blog.getTitolo());
			blog1.setTempo_di_lettura(blog.getTempo_di_lettura());
			blog1.setCover(blog.getCover());
			return blog1;
		} else {
			throw new BlogNonTrovatoException("Blog non trovato");
		}
	}

	public String delete(int id) throws BlogNonTrovatoException {
		Optional<Blog> blogOpt = getById(id);

		if (blogOpt.isPresent()) {
			blogs.remove(blogOpt.get());
			return "blog cancellato";
		} else {
			throw new BlogNonTrovatoException("blog non trovato");
		}
	}
}
