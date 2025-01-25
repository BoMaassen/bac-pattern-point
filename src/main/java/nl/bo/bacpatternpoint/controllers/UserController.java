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
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserCreateDto userCreateDto){
        UserResponseDto userResponseDto = userService.createUser(userCreateDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userResponseDto.getId()).toUri();

        return ResponseEntity.created(location).body(userResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.getUserById(id);

        return ResponseEntity.ok(userResponseDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@Valid @PathVariable Long id, @RequestBody UserUpdateDto userUpdateDto){

        UserResponseDto userResponseDto = userService.updateUser(id, userUpdateDto);
        return ResponseEntity.ok(userResponseDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        boolean isDeleted = userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }



}