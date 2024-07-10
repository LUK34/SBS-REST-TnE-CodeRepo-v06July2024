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
				    "cno": 101,
				    "cname": "rajesh",
				    "favColors": 
				    [
				        "red","blue","green"
				    ],
				    "academics":
				    [
				        "10+2","B.Tech","M.Tech"
				    ],
				    "phoneNumbers":
				    [
				        5535353435,54353455,5353433543
				    ],
				    "billDetails":
				    {
				        "x-mas tree":6546.77,
				        "cake":5345.5,
				        "chocolates":6789.6
				    },
				    "addrs":
				    {
				        "houseNo":"1-2-4/566",
				        "streetName":"RKStreet",
				        "location":"hyd",
				        "pinCode":522345
				    }
				}
		
	//OUTPUT:
	 
	 Customer(cno=101, cname=rajesh, favColors=[red, blue, green], 
	 academics=[10+2, B.Tech, M.Tech], phoneNumbers=[5353433543, 54353455, 5535353435], 
	 billDetails={x-mas tree=6546.77, cake=5345.5, 
	 chocolates=6789.6}, addrs=Address(houseNo=1-2-4/566, 
	 streetName=RKStreet, location=hyd, pinCode=522345)) 
	   
	 			
	 */
	
	
	
	/*
	 
	 	 Type: POST -> raw, XML
	 
	 // Enter the below data:
	 
	
	// INPUT:
	
				<Customer>
			    <cno>101</cno>
			    <cname>rajesh</cname>
			    <favColors>
			        <color>red</color>
			        <color>blue</color>
			        <color>green</color>
			    </favColors>
			    <academics>
			        <academic>10+2</academic>
			        <academic>B.Tech</academic>
			        <academic>M.Tech</academic>
			    </academics>
			    <phoneNumbers>
			        <phoneNumber>5535353435</phoneNumber>
			        <phoneNumber>54353455</phoneNumber>
			        <phoneNumber>5353433543</phoneNumber>
			    </phoneNumbers>
			    <billDetails>
			        <Christmas_Tree>6546.77</Christmas_Tree>
			        <cake>5345.5</cake>
			        <chocolates>6789.6</chocolates>
			    </billDetails>
			    <addrs>
			        <houseNo>1-2-4/566</houseNo>
			        <streetName>RKStreet</streetName>
			        <location>hyd</location>
			        <pinCode>522345</pinCode>
			    </addrs>
			</Customer>
	
	
	//OUTPUT:
	 
	 Customer(cno=101, cname=rajesh, favColors=[red, blue, green], 
	 academics=[10+2, B.Tech, M.Tech], phoneNumbers=[5353433543, 54353455, 5535353435], 
	 billDetails={Christmas_Tree=6546.77, cake=5345.5, chocolates=6789.6}, 
	 addrs=Address(houseNo=1-2-4/566, streetName=RKStreet, location=hyd, pinCode=522345))
	
	
	 */
	
	
	
	
	
	
}




