package com.backend.Pill_Pick.Mapper;

import com.backend.Pill_Pick.dto.UserDto;
import com.backend.Pill_Pick.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user)
    {
        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
    }
    public static User mapToUser(UserDto userDto)
    {
        return new User(userDto.getId(), userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
    }
}
