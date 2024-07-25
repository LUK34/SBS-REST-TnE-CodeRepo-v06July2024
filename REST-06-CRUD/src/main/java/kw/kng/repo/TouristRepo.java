package kw.kng.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import kw.kng.entities.Tourist;

public interface TouristRepo extends JpaRepository<Tourist, Long> 
{

	@Query("from Tourist where city in(:city1,:city2,:city3) order by tid asc")
	public List<Tourist> findTouristByCities(String city1, String city2, String city3);

	@Query("delete from Tourist where budget>=:start and budget<=:end")
	@Modifying
	@Transactional
	public int removeTouristByBudgetRange(@Param("start") double start, @Param("end") double end);
	
	@Query("from Tourist where budget>=:start and budget<=:end order by budget asc")
	public List<Tourist> findTouristByBudgetRange(@Param("start") double start, @Param("end") double end);

}
