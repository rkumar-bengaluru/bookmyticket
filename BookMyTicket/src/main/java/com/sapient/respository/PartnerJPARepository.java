package com.sapient.respository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sapient.entity.Partner;

public interface PartnerJPARepository extends JpaRepository<Partner, Long>{
	/**
	 * Custom query to find name containing the given name.
	 * 
	 * @param name
	 * @return
	 */
	@Query("Select c from partners c where c.name like  %:name%")
	Set<Partner> findByName(@Param("name") String name);
}
