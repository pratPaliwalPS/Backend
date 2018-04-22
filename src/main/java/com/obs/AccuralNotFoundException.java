package com.obs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccuralNotFoundException extends RuntimeException {

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccuralNotFoundException(String exception) {
		    super(exception);
		  }
}
