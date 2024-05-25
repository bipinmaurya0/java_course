package com.restApiForTesting.restFullApiwebservices;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Entity(name="user_tables")
public class Users {
	
	
	@Id
	private Integer ID;
	@Size(min=2)
	@JsonProperty("User_name")
	private String name;
	@Past
	private LocalDate birth;

	
	
	public Users(int iD, String name, LocalDate birth) {
		super();
		ID = iD;
		this.name = name;
		this.birth = birth;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Users [ID=" + ID + ", name=" + name + ", birth=" + birth + "]";
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
