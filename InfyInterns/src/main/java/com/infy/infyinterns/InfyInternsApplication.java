package com.infy.infyinterns;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infy.infyinterns.entity.Mentor;
import com.infy.infyinterns.entity.Project;
import com.infy.infyinterns.repository.MentorRepository;
import com.infy.infyinterns.repository.ProjectRepository;

@SpringBootApplication
public class InfyInternsApplication implements CommandLineRunner{

	@Autowired
	private MentorRepository mentorRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(InfyInternsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("--@@@@@@@@@@@@---");
//		List<Mentor> list=mentorRepository.findAll();
//	
//		list.forEach(m-> System.out.println(m));
//		System.out.println("-----------------");
		
		/*
		 * List<Mentor> projectMentored =
		 * mentorRepository.findByNumberOfProjectsMentored(90);
		 * projectMentored.forEach(m-> System.out.println(m));
		 */
//		List<Project> findAll = projectRepository.findAll();
//		findAll.forEach(p-> System.out.println(p));
	}

}




