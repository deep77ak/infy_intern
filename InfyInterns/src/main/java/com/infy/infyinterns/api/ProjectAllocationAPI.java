package com.infy.infyinterns.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.infyinterns.dto.MentorDTO;
import com.infy.infyinterns.dto.ProjectDTO;
import com.infy.infyinterns.exception.InfyInternException;
import com.infy.infyinterns.service.ProjectAllocationService;
@RestController
public class ProjectAllocationAPI {

	@Autowired
	private Environment environment;
	@Autowired
	private ProjectAllocationService allocationService;
	
	// add new project along with mentor details
	@PostMapping(path ="project" )
	public ResponseEntity<String> allocateProject(@RequestBody ProjectDTO project) throws InfyInternException {
		
		Integer allocateProjectId = allocationService.allocateProject(project);
		String message=environment.getProperty("API.ALLOCATION_SUCCESS")+ " "+allocateProjectId ;
		return ResponseEntity.status(HttpStatus.CREATED).body(message+ allocateProjectId);
	}

	// get mentors based on idea owner
	public ResponseEntity<List<MentorDTO>> getMentors(Integer numberOfProjectsMentored) throws InfyInternException {

		return null;
	}

	// update the mentor of a project
	public ResponseEntity<String> updateProjectMentor(Integer projectId, Integer mentorId) throws InfyInternException {

		return null;
	}

	// delete a project
	public ResponseEntity<String> deleteProject(Integer projectId) throws InfyInternException {
		return null;
	}

}
