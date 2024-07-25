package kw.kng.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="REST_TOURIST")
public class Tourist 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long tid;
	
	@Column(length=20)
	private String tname;
	
	@Column(length=20)
	private String city;
	
	@Column(length=20)
	private String packageType;
	
	private Double budget;

}
