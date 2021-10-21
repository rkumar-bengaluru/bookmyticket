package com.sapient.respository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sapient.entity.Movie;



public interface MovieRepository extends JpaRepository<Movie, Long> {
	/**
	 * Custom query to find theatres of a partner
	 * 
	 * @param name
	 * @return
	 */
	@Query("Select c from movie c where c.screen.id = :pid")
	Set<Movie> findByPartnerId(@Param("pid")Long pid);
}