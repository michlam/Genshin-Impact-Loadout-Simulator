package michlam.genshin_simulator_backend.controller;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.UserCharacterDto;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.exception.DuplicateResourceException;
import michlam.genshin_simulator_backend.exception.ErrorResponse;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/login") // Used to denote the base URL for any user-based apis.
public class LoginController {
    private LoginService loginService;

    // Build Login User API
    @CrossOrigin(origins = "http://localhost:3000") // Allow requests from this origin
    @PostMapping // Maps get to this method
    public ResponseEntity<Object> login(@RequestBody UserDto userDto) {
        String username = userDto.getUsername();
        String password = userDto.getPassword();

        try {
            if (loginService.login(username, password)) {
                // In the future, create a JWT for user sessions.
                String response = "Login successful";
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                String response = "Invalid credentials";
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}