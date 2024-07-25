package kw.kng.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
