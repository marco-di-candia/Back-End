package epicode.it.UNIT2EsercizioS6L2.service;


import com.cloudinary.Cloudinary;
import epicode.it.UNIT2EsercizioS6L2.Dto.AutoreDto;
import epicode.it.UNIT2EsercizioS6L2.exception.AutoreNonTrovatoException;
import epicode.it.UNIT2EsercizioS6L2.model.Autore;
import epicode.it.UNIT2EsercizioS6L2.repository.AutoreRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class AutoreService {
	@Autowired
	private AutoreRepository autoreRepository;

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Autowired
	private Cloudinary cloudinary;

	public String save(AutoreDto autoreDto) {
		Autore autore = new Autore();
		autore.setNome(autoreDto.getNome());
		autore.setCognome(autoreDto.getCognome());
		autore.setEmail(autoreDto.getEmail());
		autore.setData_nascita(autoreDto.getData_nascita());

		autoreRepository.save(autore);
		sendMail(autore.getEmail());
		return "autore con id=" + autore.getId() + " creata con successo";
	}

	public List<Autore> getAll() {
		return autoreRepository.findAll();
	}

	public Optional<Autore> getById(int id) {
		return autoreRepository.findById(id);
	}
	@SneakyThrows
	public Autore update(int id, AutoreDto autoreDto)  {
		Optional<Autore> aulaOptional = getById(id);

		if (aulaOptional.isPresent()) {
			Autore autore = aulaOptional.get();
			autore.setNome(autoreDto.getNome());
			autore.setCognome(autoreDto.getCognome());
			autore.setEmail(autoreDto.getEmail());
			autore.setData_nascita(autoreDto.getData_nascita());

			return autoreRepository.save(autore);
		} else {
			throw new AutoreNonTrovatoException("autore con id=" + id + " non trovato");
		}
	}
	@SneakyThrows
	public String delete(int id) {
		Optional<Autore> autoreOptional = getById(id);

		if (autoreOptional.isPresent()) {
			autoreRepository.delete(autoreOptional.get());
			return "Aula con id=" + id + " cancellata con successo";
		} else {
			throw new AutoreNonTrovatoException("Aula con id=" + id + " non trovata");
		}
	}

	public String patchAvatar(int matricola, MultipartFile avatar) throws IOException, AutoreNonTrovatoException {
		Optional<Autore> studenteOptional = getById(matricola);

		if(studenteOptional.isPresent()){
			String url = (String) cloudinary.uploader().upload(avatar.getBytes(), Collections.emptyMap()).get("url");
			Autore studente = studenteOptional.get();
			studente.setAvatar(url);
			autoreRepository.save(studente);
			return "Studente con matricola=" + matricola + " aggiornato correttamente con la foto inviata";
		}
		else{
			throw new AutoreNonTrovatoException("autore con matricola=" + matricola + " non trovato");
		}
	}

	private void sendMail(String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Amazon");
		message.setText("il tuo pacco e in arrivo inserire pagamento 100euro");

		javaMailSender.send(message);
	}



}
