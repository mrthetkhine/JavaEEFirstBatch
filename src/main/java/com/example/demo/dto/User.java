package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class User {

   @NotNull
   @Size(min=5, message="Name must be at least 5 characters long")
   String name;
   
   @NotNull
   @Size(min=5, message="Email must be at least 5 characters long")
   String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
