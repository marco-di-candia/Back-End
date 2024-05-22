package epicode.it.UNIT2EsercizioS6L2.exception;

import epicode.it.UNIT2EsercizioS6L2.model.Errorr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(AutoreNonTrovatoException.class)
	public ResponseEntity<Object> AutoreNonTrovatohandler(AutoreNonTrovatoException e){
		Errorr error = new Errorr();
		error.setMessage(e.getMessage());
		error.setDataErrore(LocalDateTime.now());
		error.setStatoErrore(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
