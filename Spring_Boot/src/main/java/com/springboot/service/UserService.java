package com.springboot.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.springboot.dto.UserDto;
import com.springboot.model.UserTable;
import com.springboot.repository.UserRepository;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {
	
	@Autowired
	public UserRepository userRepository;

	@Autowired
	public ModelMapper modelMapper;

    public List<UserTable> getAllPerson()
    {
        return this.userRepository.findAll();
    }

	public UserDto createUser(UserDto user) {
		//UserDto userDto = modelMapper.map(user, UserDto.class);
		UserTable userTable = convertDtoToEntity(user);
		UserTable ut =  userRepository.save(userTable);
		return  convertToUserDTO(ut);
	}

	private UserTable convertDtoToEntity(UserDto userDto)
	{
		UserTable userTable = modelMapper.map(userDto, UserTable.class);
		return userTable;
	}
	private UserDto convertToUserDTO(UserTable user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

}
