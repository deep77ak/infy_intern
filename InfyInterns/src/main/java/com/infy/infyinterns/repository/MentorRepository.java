package com.infy.infyinterns.repository;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infy.infyinterns.entity.Mentor;
@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer>{
	/* The method should accept the number of projects mentored and return details 
	 * of all the mentors who are mentoring the given number of projects.
	 */
	List<Mentor> findByNumberOfProjectsMentored(Integer numberOfProjectsMentored);
}
