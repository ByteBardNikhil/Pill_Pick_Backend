package com.backend.Pill_Pick.controller;

import com.backend.Pill_Pick.dto.UserDto;
import com.backend.Pill_Pick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/people")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
       UserDto saved=userService.createUser(userDto);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @GetMapping("/{email}")
    public ResponseEntity<UserDto> getEmployeeByEmail(@PathVariable("email") String email) {
        try {
            UserDto userdto = userService.getUserByEmail(email);
            if (userdto != null) {
                return ResponseEntity.ok(userdto); // Employee found, return 200 OK with the employee DTO
            } else {
                return ResponseEntity.notFound().build(); // Employee not found, return 404 Not Found
            }
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build(); // Employee not found, return 404 Not Found
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Internal server error
        }
    }



}
