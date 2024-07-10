package kw.kng.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kw.kng.dto.Customer;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController 
{
	/*
	 1. Unselect the existing Key: Accept.
	 
	 2. Create a new step
	 	Header
	 		Key: Accept
	 		Value: application/xml
	 */
	//-------------------------------------------------------------------------------------------------------------------------
	@GetMapping("/report")
	public ResponseEntity<Customer> showData()
	{
		Customer cust = new Customer(1001,"raja","hyd",44545.77f);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	
	//-------------------------------------------------------------------------------------------------------------------------
	
	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer cust)
	{
		return cust.toString();
	}
	
	//For JSON Format: select `raw` checkbox and select dropdown option as `JSON`
	/*
	 
	{
	    "cno": 1001,
	    "cname": "raja",
	    "cadd": "hyd",
	    "billAmt":5679.0
	}
	
	*/
	
	//For XML Format: select `raw` checkbox and select dropdown option as `XML`
	/*
	
	<customer>
	    <cno>456</cno>
	    <cname>rajesh</cname>
	    <cadd>vizag</cadd>
	    <billAmt>5678</billAmt>
	</customer>
	
	 */

	//-------------------------------------------------------------------------------------------------------------------------
	
	
	
	
}
