package okta.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomerAlreadyExistsException extends RuntimeException{
	
	private String message;
	 
    public CustomerAlreadyExistsException() {}
 
    public CustomerAlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }

}
