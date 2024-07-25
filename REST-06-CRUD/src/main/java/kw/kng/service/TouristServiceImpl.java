package kw.kng.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kw.kng.dto.TouristDto;
import kw.kng.entities.Tourist;
import kw.kng.exceptions.ResourceNotFoundException;
import kw.kng.repo.TouristRepo;

@Service
public class TouristServiceImpl implements TouristService 
{
	private TouristRepo trepo;
	private ModelMapper modelMapper;
	
	
	public TouristServiceImpl(TouristRepo trepo, ModelMapper modelMapper) 
	{
		this.trepo = trepo;
		this.modelMapper=modelMapper;
	}

	//@Value("${budget.formula}")
	//private double budgetFormula;
	
	
	@Override
	public TouristDto registerTourist_Single(TouristDto touristDto)
	{
		Tourist tourist = modelMapper.map(touristDto, Tourist.class);
		
		Tourist savedTourist = trepo.save(tourist);
		
		return modelMapper.map(savedTourist, TouristDto.class);
	}

	@Override
	public List<TouristDto> registerTourist_Multiple(List<TouristDto> touristDto)
	{
		
		List<Tourist> touristList = touristDto.stream().map(dto ->modelMapper.map(dto, Tourist.class)).collect(Collectors.toList());
 		
		List<Tourist> savedTouristList= trepo.saveAll(touristList);
		
		return savedTouristList.stream().map(t->modelMapper.map(t, TouristDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<TouristDto> fetchAllTourists() 
	{
		List<Tourist> touristList = trepo.findAll();
		
		touristList.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		
		return touristList.stream().map(t -> modelMapper.map(t, TouristDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<TouristDto> fetchAllTouristByCities(String city1, String city2, String city3) 
	{
		//Fetch the list data to ENTITY
		List<Tourist> tcl = trepo.findTouristByCities(city1, city2, city3);
		
		//Transfer the ENTITY data to DTO LIST
		return tcl.stream().map(t -> modelMapper.map(t, TouristDto.class)).collect(Collectors.toList());
	}

	@Override
	public TouristDto fetchTouristById(long tid) 
	{
		Tourist tourist = trepo.findById(tid).orElseThrow(() -> new ResourceNotFoundException("Tourist with id "+tid+" not found in DB."));
		return modelMapper.map(tourist, TouristDto.class);
	}   

	@Override
	public TouristDto updateTouristDetails(Long id, TouristDto tourist) 
	{
		//check if the id exist in the db or else throw `ResourceNotFoundException`
		Tourist toury = trepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tourist with id "+id+" not found in DB."));
		
		toury.setTname(tourist.getTname());
		toury.setCity(tourist.getCity());
		toury.setBudget(tourist.getBudget());
		toury.setPackageType(tourist.getPackageType());
		
		Tourist savedTourist = trepo.save(toury);
		
		return modelMapper.map(savedTourist, TouristDto.class);
	}

	@Override
	public void deleteTouristById(long id) 
	{
		//check if the id exist in the db or else throw `ResourceNotFoundException`
		Tourist toury = trepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tourist with id "+id+" not found in DB."));
				
		trepo.deleteById(id);
	}

	@Override
	public TouristDto updateTouristBudegtById(long id, double hikePercentage)
	{
		//Get the Tourist by id
		//check if the id exist in the db or else throw `ResourceNotFoundException`
		Tourist toury = trepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tourist with id "+id+" not found in DB."));
		
		//Get existing budget of teh Tourist
		double budget = toury.getBudget();
		double newBudget= budget + (budget * hikePercentage/100.0);
		
		//Update the Tourist with new Budget
		toury.setTname(toury.getTname());
		toury.setCity(toury.getCity());
		toury.setBudget(toury.getBudget());
		toury.setBudget(newBudget);
		Tourist savedTourist=trepo.save(toury);
		
		return modelMapper.map(savedTourist, TouristDto.class);
	}

	@Override
	public String removeTouristsByBudgetRange(double start, double end) 
	{
		int count = trepo.removeTouristByBudgetRange(start, end);
		return count==0 ? "Tourists not found for deletion: ":"Tourist Records: "+count+" are found and deleted";
	}

	@Override
	public List<TouristDto> fetchTouristByBudgetRange(double start, double end) 
	{
		List<Tourist> touristList = trepo.findTouristByBudgetRange(start, end);
		touristList.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		
		return touristList.stream().map(t -> modelMapper.map(t, TouristDto.class)).collect(Collectors.toList());
	}
	
	
	
	
	
	
	
	

}
