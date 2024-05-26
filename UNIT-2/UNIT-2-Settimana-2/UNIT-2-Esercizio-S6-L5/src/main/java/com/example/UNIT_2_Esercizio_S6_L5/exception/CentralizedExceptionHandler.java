package com.example.UNIT_2_Esercizio_S6_L5.exception;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {
	public static void handleException(Exception e) {
		if (e instanceof BadRequestException) {
			System.out.println("Bad Request: " + e.getMessage());
		} else if (e instanceof NotFoundException) {
			System.out.println("Not Found: " + e.getMessage());
		} else {
			System.out.println("Errore generico: " + e.getMessage());
		}
	}
}

