package kw.kng.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TouristDto 
{
	private Long tid;
	
	@NotBlank(message = "Name should not be NULL/EMPTY")
	@Size(max = 20, message = "Name should be at most 20 characters")
	private String tname;
	
	@NotBlank(message = "City should not be NULL/EMPTY")
	@Size(max = 20, message = "City should be at most 20 characters")
	private String city;
	
	@NotBlank(message = "Package should not be NULL/EMPTY")
	@Size(max = 20, message = "Package should be at most 20 characters")
	private String packageType;
	
	@NotNull(message = "Budget should not be NULL/EMPTY")
	private Double budget;

}
