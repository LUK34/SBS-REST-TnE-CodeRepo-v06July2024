package kw.kng.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationController 
{
	//Action: GET , Url: http://localhost:8081/RestApp/customerapi
	@GetMapping
	public ResponseEntity<String> showCustomersReport()
	{
		return new ResponseEntity<String>("From GET-showCustomersReport Method:: ", HttpStatus.OK);
	}
	
	//Action: POST , Url: http://localhost:8081/RestApp/customerapi
	@PostMapping
	public ResponseEntity<String> registerCustomersReport()
	{
		return new ResponseEntity<String>("From POST-registerCustomersReport Method:: ", HttpStatus.OK);
	}
	
	
	//Action: PUT , Url: http://localhost:8081/RestApp/customerapi
	@PutMapping
	public ResponseEntity<String> updateCustomerReport()
	{
		return new ResponseEntity<String>("From PUT-updateCustomerReport() Method:: ", HttpStatus.OK);
	}
	
	
	//Action: PATCH , Url: http://localhost:8081/RestApp/customerapi
	@PatchMapping
	public ResponseEntity<String> updateCustomerByNo()
	{
		return new ResponseEntity<String>("From PATCH-updateCustomerByNo() Method:: ", HttpStatus.OK);
	}
	
	
	//Action: DELETE , Url: http://localhost:8081/RestApp/customerapi
	@DeleteMapping
	public ResponseEntity<String> deleteCustomer()
	{
		return new ResponseEntity<String>("From DELETE-deleteCustomer() Method::", HttpStatus.OK);
	}
	
	
}
