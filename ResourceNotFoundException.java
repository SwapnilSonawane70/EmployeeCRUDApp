//package net.javaguides.EMS.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
//public class ResourceNotFoundException extends RuntimeException {
//
//	public ResourceNotFoundException(String message) {
//		super(message);
//	}
//	
//}
package net.javaguides.EMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Annotation to map this exception to a specific HTTP status code (404 NOT FOUND)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    // Constructor that accepts a message and passes it to the superclass (RuntimeException)
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
