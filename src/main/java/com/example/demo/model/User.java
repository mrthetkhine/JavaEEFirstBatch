package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	Long id;
	
	@Column(name="name")
    String name;
   
	@Column(name="email")
    String email;
	
	@Column(name="gender")
    String gender;
   
	@ManyToOne( /*cascade = CascadeType.ALL*/)
	@JoinColumn(name = "course_id")
	private Course course;
	
	@Column(name="password")
    String password;
	
	@ManyToMany
	@JoinTable(name = "user_role",
    	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    	inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	 private Set<Role> roles;
	
   public User(Long id, String name, String email , String gender)
   {
	   this.id = id;
	   this.name = name;
	   this.email = email;
	   this.gender = gender;
   }
  
   public User()
   {
	   
   }
   
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
