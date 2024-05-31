package epicode.it.FinalProgect.controller;


import epicode.it.FinalProgect.Dto.UtenteDto;
import epicode.it.FinalProgect.Dto.UtenteLoginDto;
import epicode.it.FinalProgect.exceptions.BadRequestException;
import epicode.it.FinalProgect.service.AuthService;
import epicode.it.FinalProgect.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private AuthService authService;

	@PostMapping("/auth/register")
	public String register(@RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).reduce("", (s, s2)->s+s2));
		}

		return utenteService.saveUtente(utenteDto);
	}

	@PostMapping("/auth/login")
	public String login(@RequestBody @Validated UtenteLoginDto utenteLoginDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).reduce("", (s,s2)->s+s2));
		}

		return authService.authenticateUtenteAndCreateToken(utenteLoginDto);
	}
}