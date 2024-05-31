package epicode.it.FinalProgect.repository;

import epicode.it.FinalProgect.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	Optional<Utente> findByEmail(String email);
}