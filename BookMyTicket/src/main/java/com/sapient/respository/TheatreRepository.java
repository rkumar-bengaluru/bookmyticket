package com.sapient.respository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sapient.entity.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
	/**
	 * Custom query to find name containing the given name.
	 * 
	 * @param name
	 * @return
	 */
	@Query("Select c from theatre c where c.name like  %:name%")
	Set<Theatre> findByName(@Param("name") String name);
	@Query("Select c from theatre c where c.partner.id = :pid")
	Set<Theatre> findByPartnerId(@Param("pid")Long pid);
}
