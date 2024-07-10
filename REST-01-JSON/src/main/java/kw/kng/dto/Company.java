package kw.kng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company 
{
	private String name;
	private String addrs;
	private String type;
	private Integer size;

}
