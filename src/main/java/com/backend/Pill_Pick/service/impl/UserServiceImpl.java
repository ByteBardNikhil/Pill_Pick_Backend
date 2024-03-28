package com.backend.Pill_Pick.service.impl;

import com.backend.Pill_Pick.Mapper.UserMapper;
import com.backend.Pill_Pick.dto.UserDto;
import com.backend.Pill_Pick.entity.User;
import com.backend.Pill_Pick.repository.UserRepository;
import com.backend.Pill_Pick.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

   private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {

        User user= UserMapper.mapToUser(userDto);
       User saved=userRepository.save(user);



        return UserMapper.mapToUserDto(saved);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Map the User entity to a UserDto object
            UserDto userDto = UserMapper.mapToUserDto(user);
            return userDto;
        } else {
            // If the user does not exist, return null or throw an exception
            // You can handle this based on your application requirements
            return null;
        }
    }
}
