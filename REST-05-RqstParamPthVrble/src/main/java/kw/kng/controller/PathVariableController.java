package kw.kng.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pv")
public class PathVariableController 
{
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	@GetMapping("/report-case1/{no}/{name}")
	public String reportCase1(@PathVariable(name="name")String cname,
							@PathVariable Integer no)
	{
		return no +" "+cname;
	}

	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv/report-case1/1/luke
	//OUTPUT -> 1 luke
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv/report-case1/luke/1
	//OUTPUT ->
	
	/*
	 	400 -> Bad Request
	 */
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv/report-case1/1/luke/hyd
	//OUTPUT ->
	
	/*
 		400 -> Bad Request
	 */
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv/report-case1/1
	//OUTPUT ->
	
	/*
			400 -> Bad Request
	 */
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv/report-case1
	//OUTPUT ->
	
	/*
			400 -> Bad Request
	 */
	
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	@GetMapping("/report-case2/{no}/{name}")
	public String reportCase2(@PathVariable(name="name", required=false)String cname,
							@PathVariable(name="no", required=false) Integer no)
	{
		return no +" "+cname;
	}
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv/report-case2//luke
	//OUTPUT ->
	
	/*
	 	404 -> Not Found
	 */
	
	//INPUT -> Type: GET , URL: http://localhost:8081/RestApp/pv/report-case2/1/
	//OUTPUT ->
	
	/*
	 	404 -> Not Found
	 */
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------

	//Multiple Request Paths:
	@GetMapping(value= { "/report/{eno}/{ename}", "/report/{eno}", "/report/no/{ename}" })
	public ResponseEntity<String> showReport2(@PathVariable(name="eno", required=false) Integer no,
											@PathVariable(name="ename", required=false)String ename)
	{
		System.out.println(no+"...."+ename);
		return new ResponseEntity<String>(no+"..."+ename, HttpStatus.OK);
	}
	
	//INPUT -> Type: Get, URL: http://localhost:8081/RestApp/pv/report/1/luke
	//OUTPUT -> 1....luke
	
	
	//INPUT -> Type: Get, URL: http://localhost:8081/RestApp/pv/report/no/luke
	//OUTPUT -> null....luke
	
	//INPUT -> Type: Get, URL: http://localhost:8081/RestApp/pv/report/1
	//OUTPUT -> 1....null
	
// ----------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
}
