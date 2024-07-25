package kw.kng.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kw.kng.dto.TouristDto;
import kw.kng.exceptions.GenericException;
import kw.kng.service.TouristService;

@RestController
@RequestMapping("/tourist")
public class TouristController
{

	private TouristService ts;

	public TouristController(TouristService ts) 
	{
		this.ts = ts;
	}
	
	@PostMapping("/create-single")
	public ResponseEntity<String> createTourist_Single(@RequestBody @Valid TouristDto touristDto)
	{
		try 
		{
			TouristDto savedTouristDto= ts.registerTourist_Single(touristDto);
			
			return new ResponseEntity<>("Tourist with id: "+savedTouristDto.getTid()+" saved into DB !!!", HttpStatus.CREATED);
			
		}
		catch (Exception e)
		{
			throw new GenericException("Not able to save single Tourist record into DB!!!");
		}
	}
	
	@PostMapping("/create-multiple")
	public ResponseEntity<String> createTourist_Multiple(@RequestBody @Valid List<@Valid TouristDto> touristDto)
	{
		
		try 
		{
			List<TouristDto> savedTouristDto= ts.registerTourist_Multiple(touristDto);
			List<Long> savedTouristIds = savedTouristDto.stream().map(TouristDto::getTid).collect(Collectors.toList());
			return new ResponseEntity<>("List of Tourists with ids:{"+savedTouristIds+"}are saved into DB.",HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			throw new GenericException("Not able to save multiple Tourist record into DB!!!");
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourist()
	{
		try 
		{
			List<TouristDto> listy =ts.fetchAllTourists();
			return new ResponseEntity<List<TouristDto>>(listy, HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Exception occured while fetching data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	@GetMapping("/findAll/{city1}/{city2}/{city3}")
	public ResponseEntity<?> fetchTouristByCity(@PathVariable(required=false) String city1,
												@PathVariable(required=false) String city2,
												@PathVariable(required=false) String city3)
	{
		try 
		{
			List<TouristDto> listy =ts.fetchAllTouristByCities(city1, city2,city3);
			return new ResponseEntity<List<TouristDto>>(listy, HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Exception occured while fetching data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Long id)
	{
		
			TouristDto tourist = ts.fetchTouristById(id);
			return new ResponseEntity<TouristDto>(tourist, HttpStatus.OK);
	
	}
	
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<?> updateTouristDetailsByid(@PathVariable("id") Long id, @RequestBody @Valid TouristDto touristDto)
	{
		
			TouristDto toury = ts.updateTouristDetails(id, touristDto);
			return ResponseEntity.ok(toury);
					
	}
	
	@PatchMapping("/patchupdate/{id}/{percentage}")
	public ResponseEntity<?> modifyTouristBudgetDetailsById(@PathVariable("id") long id, @PathVariable("percentage") double percentage)
	{
			TouristDto toury= ts.updateTouristBudegtById(id, percentage);
			return ResponseEntity.ok(toury);
	}
	
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteTouristById(@PathVariable("id") Long id)
	{	
			 ts.deleteTouristById(id);
			 return ResponseEntity.ok("Tourist with id: "+id+" deleted successfully from DB!!!");
	}
	
	@DeleteMapping("/deleteByBudgetRange/{start}/{end}")
	public ResponseEntity<?> deleteTouristByRange(@PathVariable("start") double start,
												  @PathVariable("end") double end)
	{
		try 
		{
			String resultMsg=ts.removeTouristsByBudgetRange(start, end);
			return new ResponseEntity<String>(resultMsg, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findByBudgetRange/{start}/{end}")
	public ResponseEntity<?> selectTouristByRange(@PathVariable("start") double start,
												  @PathVariable("end") double end)
	{
		try 
		{
			List<TouristDto> listy =ts.fetchTouristByBudgetRange(start, end);
			return new ResponseEntity<List<TouristDto>>(listy, HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<String>("Exception occured while fetching data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
}
