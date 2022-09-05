package com.infy.infyinterns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.infyinterns.dto.MentorDTO;
import com.infy.infyinterns.dto.ProjectDTO;
import com.infy.infyinterns.entity.Mentor;
import com.infy.infyinterns.entity.Project;
import com.infy.infyinterns.exception.InfyInternException;
import com.infy.infyinterns.repository.MentorRepository;
import com.infy.infyinterns.repository.ProjectRepository;

@Service
@Transactional
public class ProjectAllocationServiceImpl implements ProjectAllocationService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private MentorRepository mentorRepository;

	/*
	 * public Integer allocateProject(ProjectDTO project) 
	 * 
	 * This method is used to  allocate a new project to an existing mentor. 
	 * 
	 * Invoke appropriate method of MentorRepository which will retrieve the mentor details using the given
	 * mentorId (available in ProjectDTO). 
	 * If mentor does not exist, then throw an object of InfyInternException with message 
	 * “Service.MENTOR_NOT_FOUND” If
	 * mentor exists and the number of projects mentored by retrieved mentor is
	 * greater than or equal to 3, then throw an object of InfyInternException with
	 * message “Service.CANNOT_ALLOCATE_PROJECT” 
	 * Else, create a new Project object
	 * and populate it with received ProjectDTO details. The above created Project
	 * should be allocated to the retrieved Mentor. After successful allocation, the
	 * numberOfProjectsMentored by the corresponding mentor must be incremented by
	 * 1. The project details should be saved to the database and return the
	 * generated projectId.
	 */
	@Override
	public Integer allocateProject(ProjectDTO project) throws InfyInternException {
		Mentor mentor=
				mentorRepository.findById(project.getMentorDTO().getMentorId())
				.orElseThrow(()-> new InfyInternException("Service.MENTOR_NOT_FOUND"));
		
		if(mentor.getNumberOfProjectsMentored()>=3) {
			throw new InfyInternException("Service.CANNOT_ALLOCATE_PROJECT");
		}
		Project project2=new Project();
		//first u have to copy all data from project--> project2
		project2.setIdeaOwner(project.getIdeaOwner());
		project2.setMentor(mentor);
		project2.setProjectName(project.getProjectName());
		project2.setProjectId(project.getProjectId());
		project2.setReleaseDate(project.getReleaseDate());
		mentor.setNumberOfProjectsMentored(mentor.getNumberOfProjectsMentored()+1);
		
		// need to increse project count for that mentor
		projectRepository.save(project2);
		
		
		return project2.getProjectId();
	}

	@Override
	public List<MentorDTO> getMentors(Integer numberOfProjectsMentored) throws InfyInternException {
		return null;
	}

	@Override
	public void updateProjectMentor(Integer projectId, Integer mentorId) throws InfyInternException {

	}

	@Override
	public void deleteProject(Integer projectId) throws InfyInternException {

	}
}