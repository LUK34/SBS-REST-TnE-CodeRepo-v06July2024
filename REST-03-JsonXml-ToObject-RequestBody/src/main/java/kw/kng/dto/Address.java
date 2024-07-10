package kw.kng.dto;

import lombok.Data;

@Data
public class Address 
{
	private String houseNo;
	private String streetName;
	private String location;
	private Long pinCode;
}
