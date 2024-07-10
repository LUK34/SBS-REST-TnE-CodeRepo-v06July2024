package kw.kng.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kw.kng.dto.Company;
import kw.kng.dto.Customer;

@RestController
@RequestMapping("/customerapi2")
public class CustomerOperation2Controller 
{
	@GetMapping("/report1")
	public ResponseEntity<Customer> showData()
	{
		Customer cust = new Customer(1001,"raja",54566.66f,
						new String[] {"read","green","blue"},
						List.of("10th","10+2","B.Tech"),
						Set.of(544535345L,7576575L,6465654L),
						Map.of("aadhar",35345435L,"panNo",354353534L),
						new Company("SAMSUNG","hyd","Electronics",4000)
				);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust,status);
	}
	/*
	 	//OUTPUT:
	 	//-----------
	 
	 	{
		    "cno": 1001,
		    "cname": "raja",
		    "billAmt": 54566.66,
		    "favColors": [
		        "read",
		        "green",
		        "blue"
		    ],
		    "studies": [
		        "10th",
		        "10+2",
		        "B.Tech"
		    ],
		    "phoneNumbers": [
		        544535345,
		        7576575,
		        6465654
		    ],
		    "idDetails": 
		    {
		        "panNo": 354353534,
		        "aadhar": 35345435
		    },
		    "company": 
		    {
		        "name": "SAMSUNG",
		        "addrs": "hyd",
		        "type": "Electronics",
		        "size": 4000
		    }
		}
	 */
	
}
