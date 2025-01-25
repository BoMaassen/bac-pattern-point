package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.config.PasswordEncoderUtil;
import nl.bo.bacpatternpoint.dtos.UserCreateDto;
import nl.bo.bacpatternpoint.dtos.UserResponseDto;
import nl.bo.bacpatternpoint.dtos.UserUpdateDto;
import nl.bo.bacpatternpoint.mappers.UserMapper;
import nl.bo.bacpatternpoint.models.User;
import nl.bo.bacpatternpoint.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserCreateDto userCreateDto){

        String encodedPassword = PasswordEncoderUtil.encodePassword(userCreateDto.getPassword());

        User newUser = userRepository.save(UserMapper.toEntity(userCreateDto, encodedPassword));
        return UserMapper.toResponseDto(newUser);
    }

    public UserResponseDto updateUser(Long id, UserUpdateDto userUpdateDto){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Geen gebruiker gevonden met id" + id));

        String encodedPassword = PasswordEncoderUtil.encodePassword(userUpdateDto.getPassword());

        User updatedUser = UserMapper.toEntity(userUpdateDto, encodedPassword);

        updatedUser.setId(user.getId());
        updatedUser = userRepository.save(updatedUser);

        return UserMapper.toResponseDto(updatedUser);

    }

    public UserResponseDto getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Geen gebruiker gevonden"));
        var principal = SecurityContextHolder.getContext().getAuthentication();

        if (principal.getName().equals(user.getUsername())){
            return UserMapper.toResponseDto(user);
        }
        else throw new RuntimeException("niet toegestaan ");
    }

    public boolean deleteUser(Long id){
        userRepository.deleteById(id);

        return true;
    }




}
