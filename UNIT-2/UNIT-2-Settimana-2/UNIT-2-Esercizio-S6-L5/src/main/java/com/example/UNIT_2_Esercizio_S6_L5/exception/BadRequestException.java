package com.example.UNIT_2_Esercizio_S6_L5.exception;

public class BadRequestException extends RuntimeException{
	public BadRequestException(String message){
		super(message);
	}
}
