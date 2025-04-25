package michlam.genshin_simulator_backend.controller;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.config.JwtService;
import michlam.genshin_simulator_backend.dto.UserCharacterDto;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.dto.UserTeamDto;
import michlam.genshin_simulator_backend.entity.User;
import michlam.genshin_simulator_backend.entity.UserTeam;
import michlam.genshin_simulator_backend.exception.DuplicateResourceException;
import michlam.genshin_simulator_backend.exception.ErrorResponse;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.mapper.Mapper;
import michlam.genshin_simulator_backend.service.AuthenticationService;
import michlam.genshin_simulator_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from this origin
@RequestMapping("/api/users") // Used to denote the base URL for any user-based apis.
public class UserController {
    private UserService userService;
    private JwtService jwtService;


    // Build Add User REST API
    @PostMapping("add") // Maps post to this method
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) { // converts JSON body to Java object
        try {
            UserDto savedUserDto = userService.createUser(userDto);
            User savedUser = Mapper.mapToUser(savedUserDto);


            // Generate the JWT
            String jwtToken = jwtService.generateToken(savedUser);
            return new ResponseEntity<>(
                    AuthenticationResponse.builder().token(jwtToken).build(),
                    HttpStatus.CREATED
            );

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

    // Build Unlock User Character REST API
    @PostMapping("/characters/unlock")
    public ResponseEntity<Object> unlockUserCharacter(@RequestBody Map<String, String> json) {
        Long id = Long.parseLong(json.get("id"));
        String name = json.get("name");

        try {
            UserCharacterDto userCharacterDto = userService.unlockUserCharacter(id, name);
            return ResponseEntity.ok(userCharacterDto);
        } catch (ResourceNotFoundException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } catch (DuplicateResourceException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    // Build Get User Characters By ID REST API
    @PostMapping("/characters") // Maps post to this method
    public ResponseEntity<Object> getUserCharactersById(@RequestBody Map<String, String> json) {
        Long userId = Long.parseLong(json.get("id"));

        try {
            List<String> userCharacterDtos = userService.getUserCharactersById(userId);
            return ResponseEntity.ok(userCharacterDtos);
        } catch (ResourceNotFoundException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Build Get User Teams By ID REST API
    @PostMapping("/teams")
    public ResponseEntity<Object> getUserTeamsById(@RequestBody Map<String, String> json) {
        Long userId = Long.parseLong(json.get("id"));

        try {
            List<UserTeam> userTeams = userService.getUserTeamsById(userId);
            return ResponseEntity.ok(userTeams);
        } catch (ResourceNotFoundException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Build Update User Team REST API
    @PutMapping("/teams")
    public ResponseEntity<Object> updateUserTeam(@RequestBody UserTeamDto updatedUserTeam) {
        try {
            UserTeamDto userTeamDto = userService.updateUserTeam(updatedUserTeam);
            return ResponseEntity.ok(userTeamDto);
        } catch (ResourceNotFoundException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
