package nl.bo.bacpatternpoint.controllers;

import jakarta.validation.Valid;
import nl.bo.bacpatternpoint.dtos.*;
import nl.bo.bacpatternpoint.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        UserResponseDto userResponseDto = userService.createUser(userCreateDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}").buildAndExpand(userResponseDto.getUsername()).toUri();
        return ResponseEntity.created(location).body(userResponseDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponseDto> getUserByUsername(@PathVariable String username) {
        UserResponseDto userResponseDto = userService.getUserByUsername(username);
        return ResponseEntity.ok(userResponseDto);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserResponseDto> updateUser(@Valid @PathVariable String username, @RequestBody UserUpdateDto userUpdateDto) {
        UserResponseDto userResponseDto = userService.updateUser(username, userUpdateDto);
        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        boolean isDeleted = userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }
}