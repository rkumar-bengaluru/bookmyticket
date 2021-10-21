package com.sapient.respository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sapient.entity.Screen;



public interface ScreenRepository extends JpaRepository<Screen, Long> {
	/**
	 * Custom query to find theatres of a partner
	 * 
	 * @param name
	 * @return
	 */
	@Query("Select c from screen c where c.theatre.id = :pid")
	Set<Screen> findByPartnerId(@Param("pid")Long pid);
}