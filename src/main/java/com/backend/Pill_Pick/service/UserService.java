package com.backend.Pill_Pick.service;

import com.backend.Pill_Pick.dto.UserDto;

public interface UserService {
   UserDto createUser(UserDto userDto);
   UserDto getUserByEmail(String email);
}
