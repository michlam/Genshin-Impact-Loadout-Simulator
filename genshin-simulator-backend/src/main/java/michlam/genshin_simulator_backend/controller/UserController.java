package michlam.genshin_simulator_backend.controller;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.entity.User;
import michlam.genshin_simulator_backend.exception.DuplicateResourceException;
import michlam.genshin_simulator_backend.exception.ErrorResponse;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users") // Used to denote the base URL for any user-based apis.
public class UserController {
    private UserService userService;

    // Build Add User REST API
    @PostMapping // Maps post to this method
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) { // converts JSON body to Java object
        try {
            UserDto savedUser = userService.createUser(userDto);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (DuplicateResourceException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // Build Get User By ID REST API
    @GetMapping // Maps get to this method
    public ResponseEntity<Object> getUserById(@RequestBody Long userId) {
        try {
            UserDto userDto = userService.getUserById(userId);
            return ResponseEntity.ok(userDto);
        } catch (ResourceNotFoundException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Build Update User REST API
    @PutMapping // Maps put to this method
    public ResponseEntity<Object> updateUser(@RequestBody UserDto updatedUser) {
        try {
            UserDto userDto = userService.updateUser(updatedUser);
            return ResponseEntity.ok(userDto);
        } catch (ResourceNotFoundException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (DuplicateResourceException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
