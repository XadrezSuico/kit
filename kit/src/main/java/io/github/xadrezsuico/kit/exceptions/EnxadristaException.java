package io.github.xadrezsuico.kit.exceptions;

public class EnxadristaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 459123030736769561L;
	private String message;
	public EnxadristaException(String message){
		this.message = message;
	}
	public String getMessage(){
		return this.message;
	}	
}
