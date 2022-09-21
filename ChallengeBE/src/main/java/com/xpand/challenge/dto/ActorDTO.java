package com.xpand.challenge.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xpand.challenge.enums.Gender;

public class ActorDTO {

	@NotBlank(message = "Name must not be empty")
	private String name;
	
	@NotNull(message = "Birth date must not be empty")
	@JsonFormat(pattern = "yyyy/MM/dd")
	private LocalDate birthDate;
	
	@NotNull
	private Gender gender;

	public ActorDTO() {
		super();
	}

	public ActorDTO(@NotBlank(message = "Name must not be empty") String name,
			@NotNull(message = "Birth date must not be empty") LocalDate birthDate,
			@NotBlank(message = "Gender must not be empty") Gender gender) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
