package com.example.demo.servie;
import java.util.List;

import com.example.demo.dto.UserDto;
import com.example.demo.model.*;

public interface UserService {
	List<UserDto> getAllUser();
	void saveOrUpdate(UserDto user);
}
