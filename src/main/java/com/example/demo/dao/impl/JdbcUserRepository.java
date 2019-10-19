package com.example.demo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDto;

@Repository
public class JdbcUserRepository implements UserRepository{

	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcUserRepository(JdbcTemplate jdbc) {
	    this.jdbc = jdbc;
	}
	  
	@Override
	public Iterable<UserDto> findAll() {
		return jdbc.query("select id, name, email,gender from user",
			      this::mapRowUser);
	}

	@Override
	public UserDto findOne(Long id) {
		return jdbc.queryForObject(
			      "select id, name, email,gender from user where id=?",
			      this::mapRowUser, id);
	}

	@Override
	public UserDto save(UserDto user) {
		jdbc.update(
			      "insert into User ( name, email,gender) values (?, ?, ?)",
			      user.getName(),
			      user.getEmail(),
			      user.getGender());
			  return user;
	}
	private UserDto mapRowUser(ResultSet rs, int rowNum)
		    throws SQLException {
		  return new UserDto(
		      rs.getLong("id"),
		      rs.getString("name"),
		      rs.getString("email"),
		      rs.getString("gender"));
		}

	@Override
	public UserDto update(UserDto user) {
		jdbc.update(
			      "Update user set name=?,  email=?,gender=? WHERE id=?",
			      user.getName(),
			      user.getEmail(),
			      user.getGender(),
			      user.getId());
			  return user;
		
	}

	@Override
	public void deleteUser(Long id) {
		jdbc.update(
			      "delete from user WHERE id=?",
			      id);
		
	}
}
