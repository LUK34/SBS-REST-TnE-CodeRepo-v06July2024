package kw.kng.service;

import java.util.List;

import kw.kng.dto.TouristDto;

public interface TouristService 
{
	TouristDto registerTourist_Single(TouristDto touristDto);
	List<TouristDto> registerTourist_Multiple(List<TouristDto> touristDto);
	List<TouristDto> fetchAllTourists();
	List<TouristDto> fetchAllTouristByCities(String city1, String city2, String city3);
	TouristDto fetchTouristById(long tid);
	TouristDto updateTouristDetails(Long id, TouristDto tourist); 
	void deleteTouristById(long id);
	TouristDto updateTouristBudegtById(long tid, double hikePercentage);
	String removeTouristsByBudgetRange(double start, double end);
	List<TouristDto> fetchTouristByBudgetRange(double start, double end);
	
}