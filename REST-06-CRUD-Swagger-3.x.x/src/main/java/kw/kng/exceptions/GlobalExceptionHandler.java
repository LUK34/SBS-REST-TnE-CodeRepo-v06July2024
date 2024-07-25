package kw.kng.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
	
	/*
	 	ResponseEntityExceptionHandler -> this class has all the necessary methods to handle the validation error exceptions.
	 */

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
																			//Handle specific exception - ResourceNotFoundException
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleAccountException(ResourceNotFoundException ex,	 WebRequest webRequest)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
																				  ex.getMessage(),
																				  webRequest.getDescription(false),
																				  "RESOURCE_NOT_FOUND");
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
																		//Handle specifc exception= UserEmailNotFoundException
	
	@ExceptionHandler(EmailAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException(EmailAlreadyExistException ex,	 WebRequest webRequest)
	{
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),
																				  ex.getMessage(),
																				  webRequest.getDescription(false),
																				  "BAD_GATEWAY _->_EMAIL_ALREADY_EXIST");
		
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
																					//Handle Generic Exception
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGenericException(Exception ex, WebRequest webRequest)
	{
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(),
																  ex.getMessage(),
																  webRequest.getDescription(false),
																  "GENERIC_EXCEPTION_->_INTERNAL_SERVER_ERROR");
				
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(GenericException.class)
	public ResponseEntity<ErrorDetails> handleGenericException2(Exception ex, WebRequest webRequest)
	{
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(),
																  ex.getMessage(),
																  webRequest.getDescription(false),
																  "GENERIC_EXCEPTION_->_INTERNAL_SERVER_ERROR");
				
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
																				 //Handle Validation Errors
	
	//CTRL + SPACE

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
																														HttpHeaders headers,
																														HttpStatusCode status,
																														WebRequest request) 
	{
		Map<String, String> errors = new HashMap<>();
		List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
		
		errorList.forEach((error) ->
		{
			String fileName= ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fileName, message);
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	
}


/*
Exception Handling:
-----------------------------

1. Handling exceptions in Spring Boot Rest APIs is typically done using the @ControllerAdvice and @ExceptionHandler annotations.

2. @ControllerAdvice enables global exception handling for controllers.

3. @ExceptionHandler defines methods to handle specific exceptions withing a controller or globally with @ControllerAdvice.

Development Steps:
----------------------------
1. Create custom exception named.

2.Use that custom exception that was created.

3. Create ErrorDetails class to hold error response.

4. Create GlobalExceptionHandler to handle specific exception as well as generic exceptions.


*/
