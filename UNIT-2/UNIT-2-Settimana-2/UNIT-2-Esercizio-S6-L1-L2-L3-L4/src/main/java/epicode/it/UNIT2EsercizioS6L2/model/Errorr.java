package epicode.it.UNIT2EsercizioS6L2.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class Errorr {
	private String message;
	private LocalDateTime dataErrore;
	private HttpStatus statoErrore;
}
