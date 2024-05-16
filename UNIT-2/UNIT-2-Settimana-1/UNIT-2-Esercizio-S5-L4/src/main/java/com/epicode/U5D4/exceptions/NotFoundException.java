package com.epicode.U5D4.exceptions;

public class NotFoundException extends RuntimeException {
	public NotFoundException(long id) {
		super("Item with id " + id + " not found");
	}
}
