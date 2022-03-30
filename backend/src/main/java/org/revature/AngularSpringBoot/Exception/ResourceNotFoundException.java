package org.revature.AngularSpringBoot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//Whenever a record is not found in our database, the rest api will throw this custom exception. 
//With the @ResponseStatus annotation the api returns to the client the NotFoundException.


//@ResponseStatus is used to specify the response status of a controller method. 
@ResponseStatus(value = HttpStatus.NOT_FOUND)
//RunTimeException internally implements Serializable Interface.
public class ResourceNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);

    }
}
