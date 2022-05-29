package com.rra.base.exception;

public class DAOException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DAOException(Throwable t, String message) {
		super(message, t);
	}

}
