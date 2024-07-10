package kw.kng.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageapi")
public class MessageRenderController 
{
	private String msg="";
	
	//Type: GET , URL: http://localhost:8081/RestApp/messageapi/wish
	@GetMapping("/wish")
	public ResponseEntity<String> showMessage()
	{
		LocalDateTime ldt = LocalDateTime.now();
	
		int hour =ldt.getHour();
		if(hour<12)
		{
			msg="Good Morning :: Time: "+ldt;
			System.out.println(msg);
		}
		else if(hour<16)
		{
			msg="Good Afternoon:: Time: "+ldt;
			System.out.println(msg);
		}
		else if(hour<20)
		{
			msg="Good Evening:: Time: "+ldt;
			System.out.println(msg);
		}
		else
		{
			msg="Good Night:: Time: "+ldt;
			System.out.println(msg);
		}
		
		//Create and return ResponseEntity object having response content and status code.
		ResponseEntity<String> entity = new ResponseEntity<String>(msg, HttpStatus.OK);
		
		return entity;
	}

}
