package nl.bo.bacpatternpoint.services;

import nl.bo.bacpatternpoint.config.PasswordEncoderUtil;
import nl.bo.bacpatternpoint.dtos.UserCreateDto;
import nl.bo.bacpatternpoint.dtos.UserResponseDto;
import nl.bo.bacpatternpoint.dtos.UserUpdateDto;
import nl.bo.bacpatternpoint.exception.RecordNotFoundException;
import nl.bo.bacpatternpoint.exception.UnauthorizedActionException;
import nl.bo.bacpatternpoint.mappers.UserMapper;
import nl.bo.bacpatternpoint.models.User;
import nl.bo.bacpatternpoint.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public UserResponseDto updateUser(String username, UserUpdateDto userUpdateDto){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Geen gebruiker gevonden met gebruikersnaam " + username));

        var principal = SecurityContextHolder.getContext().getAuthentication();
        if (principal.getName().equals(user.getUsername())){
        String encodedPassword = PasswordEncoderUtil.encodePassword(userUpdateDto.getPassword());

        User updatedUser = UserMapper.toEntity(userUpdateDto, encodedPassword);

        updatedUser.setId(user.getId());
        User savedUser = userRepository.save(updatedUser);

        return UserMapper.toResponseDto(savedUser);
        } else throw new UnauthorizedActionException("niet toegestaan om een andere gebruiker te wijzigen");

    }

    public UserResponseDto getUserByUsername(String username){
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Geen gebruiker gevonden"));
        var principal = SecurityContextHolder.getContext().getAuthentication();

        if (principal.getName().equals(user.getUsername())){
            return UserMapper.toResponseDto(user);
        }
        else throw new UnauthorizedActionException("niet toegestaan om een andere gebruiker op te vragen");
    }

    public boolean deleteUser(String username){
        User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Geen gebruiker gevonden met gebruikersnaam " + username));
        var principal = SecurityContextHolder.getContext().getAuthentication();

        if (principal.getName().equals(user.getUsername())){
            userRepository.deleteById(user.getId());

            return true;
        }
       else throw new UnauthorizedActionException("niet toegestaan om een andere gebruiker te verwijderen");
    }
}
