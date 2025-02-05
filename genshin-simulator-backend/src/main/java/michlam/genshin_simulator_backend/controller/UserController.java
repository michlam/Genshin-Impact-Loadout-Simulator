package michlam.genshin_simulator_backend.controller;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.UserDto;
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
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) { // converts JSON body to Java object
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Build Get User By ID REST API
    @GetMapping // Maps get to this method
    public ResponseEntity<UserDto> getUserById(@RequestBody Long userId) {
        System.out.println(userId);
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }
}
