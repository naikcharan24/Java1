package com.ty;

public class InvalidQuantityException extends Exception{
	private String messag;

	public InvalidQuantityException(String messag)
	{
		this.messag=messag;
	}
	@Override 
	public String getMessage()
	{
		return messag;
	}

}
