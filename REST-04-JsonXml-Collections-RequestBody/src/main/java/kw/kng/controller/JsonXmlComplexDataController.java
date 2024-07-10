package kw.kng.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kw.kng.dto.Customer;

@RestController
public class JsonXmlComplexDataController 
{
	
	@PostMapping("/register")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer cust)
	{
		return new ResponseEntity<String>(cust.toString(), HttpStatus.OK);
	}

	/*
	 
	 Type: POST -> raw, JSON
	 
	 // Enter the below data:
	 
	 //INPUT:
	 
	{
	    "cno": 1001,
	    "cname": "raja",
	    "companiesList": [
	        {"name": "HCL", "location": "hyd", "size": 200},
	        {"name": "BPCL", "location": "blore", "size": 400},
	        {"name": "HPCL", "location": "delhi", "size": 500}
	    ],
	    "dob": "1990-11-20",
	    "purchaseDate": "2015-10-21T17:10:55",
	    "familyIds": [
	        {"aadhar": 354535, "voterId": 5353543, "panNo": 45435453},
	        {"aadhar": 314535, "voterId": 15353543, "panNo": 245435453}
	    ]
	}
	
	//OUTPUT:
	 
	 Customer(cno=1001, cname=raja, companiesList=[Company(name=HCL, location=hyd, size=200), 
	 Company(name=BPCL, location=blore, size=400), Company(name=HPCL, location=delhi, size=500)], 
	 dob=1990-11-20, purchaseDate=2015-10-21T17:10:55, familyIds=[{aadhar=354535, voterId=5353543,
	  panNo=45435453}, {aadhar=314535, voterId=15353543, panNo=245435453}])
	   
	 			
	 */
	
	
	
	/*
	 
	 	 Type: POST -> raw, XML
	 
	 // Enter the below data:
	 
	
	// INPUT:
	
			<Customer>
				    <cno>1001</cno>
				    <cname>raja</cname>
				    <companiesList>
				        <company>
				            <name>HCL</name>
				            <location>hyd</location>
				            <size>200</size>
				        </company>
				        <company>
				            <name>BPCL</name>
				            <location>blore</location>
				            <size>400</size>
				        </company>
				        <company>
				            <name>HPCL</name>
				            <location>delhi</location>
				            <size>500</size>
				        </company>
				    </companiesList>
				    <dob>1990-11-20</dob>
				    <purchaseDate>2015-10-21T17:10:55</purchaseDate>
				    <familyIds>
				        <familyId>
				            <aadhar>354535</aadhar>
				            <voterId>5353543</voterId>
				            <panNo>45435453</panNo>
				        </familyId>
				        <familyId>
				            <aadhar>314535</aadhar>
				            <voterId>15353543</voterId>
				            <panNo>245435453</panNo>
				        </familyId>
				    </familyIds>
			</Customer>
	
	
	//OUTPUT:
	 
	Customer(cno=1001, cname=raja, companiesList=[Company(name=HCL, location=hyd, size=200), 
	Company(name=BPCL, location=blore, size=400), Company(name=HPCL, location=delhi, size=500)], 
	dob=1990-11-20, purchaseDate=2015-10-21T17:10:55, familyIds=[{aadhar=354535, voterId=5353543,
	 panNo=45435453}, {aadhar=314535, voterId=15353543, panNo=245435453}])
	
	
	 */
	
	
	
	
	
	
}




