package epicode.it.FinalProgect.service;

import epicode.it.FinalProgect.Dto.UtenteLoginDto;
import epicode.it.FinalProgect.exceptions.BadRequestException;
import epicode.it.FinalProgect.exceptions.UnauthorizedException;
import epicode.it.FinalProgect.model.Utente;
import epicode.it.FinalProgect.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
	@Autowired
	private JwtTool jwtTool;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public String authenticateUtenteAndCreateToken(UtenteLoginDto utenteLoginDto) {
		Optional<Utente> utenteOptional = utenteService.getUtenteByEmail(utenteLoginDto.getEmail());

		if (utenteOptional.isPresent()) {
			Utente utente = utenteOptional.get();

			if (passwordEncoder.matches(utenteLoginDto.getPassword(), utente.getPassword())) {
				return jwtTool.createToken(utente);
			} else {
				throw new UnauthorizedException("Password errata. Fai di nuovo il login!");
			}
		} else {
			throw new UnauthorizedException("Utente non presente. Fai di nuovo il login!");
		}
	}
}