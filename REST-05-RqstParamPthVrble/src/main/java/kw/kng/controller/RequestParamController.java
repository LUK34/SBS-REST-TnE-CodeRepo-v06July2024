package kw.kng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController 
{

// ----------------------------------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/report-case1")
	public String reportCase1(@RequestParam("cno")Integer no,
							@RequestParam(required=false) String cname)
	{
		return no +" "+cname;
	}
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case1?cno=3&cname=luke
	//OUTPUT -> 3 luke
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case1?cno=3&cname=
	//OUTPUT -> 3 
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case1?cno=3
	//OUTPUT -> 3 null
	
	

// ----------------------------------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/report-case2")
	public String reportCase2(@RequestParam("cno")Integer no,
							@RequestParam(required=false) String cname)
	{
		return no +" "+cname;
	}
	
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case2?cno=3
	//OUTPUT -> 3 null
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case2?cno=3&cname=
	//OUTPUT -> 3 
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case2?cno=3&cname=luke
	//OUTPUT ->3 luke
	


// ----------------------------------------------------------------------------------------------------------------------------------------------------------


	@GetMapping("/report-case3")
	public String reportCase3(@RequestParam("cno")Integer no,
							@RequestParam(required=true) String cname)
	{
		return no +" "+cname;
	}
	
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case3?cno=3
	//OUTPUT -> 
		/*
 			400 -> Bad Request
		 */

	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case3?cno=3&cname=
	//OUTPUT -> 3 
		
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case3?cno=3&cname=luke
	//OUTPUT ->3 luke
	
	

// ----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/report-case4")
	public String reportCase4(@RequestParam("cno")Integer no,
							@RequestParam(required=false, defaultValue="king") String cname)
	{
		return no +" "+cname;
	}
	
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case3?cno=3
	//OUTPUT -> 3 king
				
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case3?cno=3&cname=
	//OUTPUT -> 3 king
		
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case3?cno=3&cname=luke
	//OUTPUT ->3 luke
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------

	@GetMapping("/report-case5")
	public String reportCase5(@RequestParam("cno")Integer no,
							@RequestParam(required=true, defaultValue="king") String cname)
	{
		return no +" "+cname;
	}
	
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case3?cno=3
	//OUTPUT -> 3 king
				
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case3?cno=3&cname=
	//OUTPUT -> 3 king
		
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/report-case3?cno=3&cname=luke
	//OUTPUT ->3 luke
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
