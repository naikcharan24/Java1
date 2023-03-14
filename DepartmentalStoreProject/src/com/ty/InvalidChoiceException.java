package com.ty;

public class InvalidChoiceException extends Exception{
	private String messag;

	public InvalidChoiceException(String messag)
	{
		this.messag=messag;
	}
	@Override 
	public String getMessage()
	{
		return messag;
	}

}
