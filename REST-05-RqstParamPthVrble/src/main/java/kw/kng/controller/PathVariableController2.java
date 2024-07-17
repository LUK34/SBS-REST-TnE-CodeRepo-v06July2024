package kw.kng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pv2")
public class PathVariableController2 
{
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/rp/no/name")
	public String reportCase1(@PathVariable(name="name", required=false)String cname,
							@PathVariable(required=false) Integer no)
	{
		return "pv2/rp -> Case 1";
	}
	
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv2/rp/no/name
	//OUTPUT -> pv2/rp -> Case 1
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/rp/{no}/name")
	public String reportCase2(@PathVariable(name="name", required=false)String cname,
							@PathVariable(required=false) Integer no)
	{
		return "pv2/rp -> Case 2";
	}
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv2/rp/1/name
	//OUTPUT -> pv2/rp -> Case 2
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	@GetMapping("/rp/no/{name}")
	public String reportCase3(@PathVariable(name="name", required=false)String cname,
							@PathVariable(required=false) Integer no)
	{
		return "pv2/rp -> Case 3";
	}
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv2/rp/no/luke
	//OUTPUT -> pv2/rp -> Case 3
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------

	
	@GetMapping("/rp/{no}/{name}")
	public String reportCase4(@PathVariable(name="name", required=false)String cname,
							@PathVariable(required=false) Integer no)
	{
		return "pv2/rp -> Case 4";
	}
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv2/rp/1/luke
	//OUTPUT -> pv2/rp -> Case 4
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------
	
		
	
}
