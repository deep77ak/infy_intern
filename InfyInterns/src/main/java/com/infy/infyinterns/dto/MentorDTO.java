package com.infy.infyinterns.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MentorDTO {

	@Pattern(regexp = "[0-9]{4}", message = "{Mentor id should be of 4 digits}")
	@NotNull(message = "{project.ideaowner.absent}")
	private Integer mentorId;

	@NotEmpty(message = "{project.mentor.absent}")
	private String mentorName;

	@NotNull(message = "{mentor.mentorid.absent}")
	private Integer numberOfProjectsMentored;

	public MentorDTO() {
		super();
	}

	public MentorDTO(Integer mentorId, String mentorName, Integer numberOfProjectsMentored) {
		super();
		this.mentorId = mentorId;
		this.mentorName = mentorName;
		this.numberOfProjectsMentored = numberOfProjectsMentored;
	}

	public Integer getMentorId() {
		return mentorId;
	}

	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public Integer getNumberOfProjectsMentored() {
		return numberOfProjectsMentored;
	}

	public void setNumberOfProjectsMentored(Integer numberOfProjectsMentored) {
		this.numberOfProjectsMentored = numberOfProjectsMentored;
	}

}
