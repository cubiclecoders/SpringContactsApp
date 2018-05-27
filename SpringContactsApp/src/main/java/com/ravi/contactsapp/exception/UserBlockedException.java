package com.ravi.contactsapp.exception;

public class UserBlockedException extends Exception{
	
	//Creates UserBlockedException without error desceription
	public UserBlockedException() {}
	
	
	//Creates UserBlockedException with error desceription
	public UserBlockedException(String errDesc) {
		super(errDesc);
	}

}
