package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.dtos.UserCreateDto;
import nl.bo.bacpatternpoint.dtos.UserResponseDto;
import nl.bo.bacpatternpoint.dtos.UserUpdateDto;
import nl.bo.bacpatternpoint.mappers.UserMapper;
import nl.bo.bacpatternpoint.models.User;
import nl.bo.bacpatternpoint.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserCreateDto userCreateDto){
        User newUser = userRepository.save(UserMapper.toEntity(userCreateDto));
        return UserMapper.toResponseDto(newUser);
    }

    public UserResponseDto updateUser(Long id, UserUpdateDto userUpdateDto){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Geen gebruiker gevonden met id" + id));

        user.setUsername(userUpdateDto.getUsername());
        user.setEmail(userUpdateDto.getEmail());
        user.setPassword(userUpdateDto.getPassword());
        user.setBiography(userUpdateDto.getBiography());

        User updatedUser = userRepository.save(user);

        return UserMapper.toResponseDto(updatedUser);

    }

    public UserResponseDto getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Geen gebruiker gevonden"));

        return UserMapper.toResponseDto(user);
    }
}
