package epicode.it.UNIT2EsercizioS6L2.exception;

public class BadRequestException extends RuntimeException{
	public BadRequestException(String message){
		super(message);
	}
}
