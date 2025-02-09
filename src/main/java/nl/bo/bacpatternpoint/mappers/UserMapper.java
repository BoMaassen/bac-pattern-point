package nl.bo.bacpatternpoint.mappers;

import nl.bo.bacpatternpoint.dtos.UserCreateDto;
import nl.bo.bacpatternpoint.dtos.UserResponseDto;
import nl.bo.bacpatternpoint.dtos.UserUpdateDto;
import nl.bo.bacpatternpoint.models.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserResponseDto toResponseDto(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        dto.setEmail(user.getEmail());
        dto.setBiography(user.getBiography());
        return dto;
    }

    public static User toEntity(UserCreateDto userCreateDto, String encodedPassword){
        User user = new User();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(encodedPassword);
        user.setRole(userCreateDto.getRole());
        user.setEmail(userCreateDto.getEmail());
        user.setBiography(userCreateDto.getBiography());
        return user;
    }

    public static User toEntity(UserUpdateDto userUpdateDto, String encodedPassword){
        User user = new User();
        user.setUsername(userUpdateDto.getUsername());
        user.setPassword(encodedPassword);
        user.setRole(userUpdateDto.getRole());
        user.setEmail(userUpdateDto.getEmail());
        user.setBiography(userUpdateDto.getBiography());
        return user;
    }

    public static List<UserResponseDto> toResponseDtoList(List<User> users){
        return users.stream().map(UserMapper::toResponseDto).collect(Collectors.toList());
    }
}
