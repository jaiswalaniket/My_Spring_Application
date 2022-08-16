package com.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.UserDto;
import com.springboot.model.UserTable;
import com.springboot.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("users")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
		/**
		 * 1. userDto should come in request
		 * 2.userdto should be passed to service
		 * 3.service should convert userdto to entity -use mapper
		 * 4.service will process the task and convert the entity back to dto and send dto to controller
		 */

		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);
	}

    @GetMapping("getallusers")
    public ResponseEntity<?> getAllPersons() {

		return ResponseEntity.ok(this.userService.getAllPerson());
    }
}
