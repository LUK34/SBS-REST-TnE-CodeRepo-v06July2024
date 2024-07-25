package kw.kng.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(
		description="TouristDto Model Information"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TouristDto 
{
	private Long tid;
	
	@Schema(
			description="Tourist Name"
	)
	@NotBlank(message = "Name should not be NULL/EMPTY")
	@Size(max = 20, message = "Name should be at most 20 characters")
	private String tname;
	
	@Schema(
			description="Tourist City"
	)
	@NotBlank(message = "City should not be NULL/EMPTY")
	@Size(max = 20, message = "City should be at most 20 characters")
	private String city;
	
	@Schema(
			description="Tourist Package Type"
	)
	@NotBlank(message = "Package should not be NULL/EMPTY")
	@Size(max = 20, message = "Package should be at most 20 characters")
	private String packageType;
	
	@Schema(
			description="Tourist Budget"
	)
	@NotNull(message = "Budget should not be NULL/EMPTY")
	private Double budget;

}
