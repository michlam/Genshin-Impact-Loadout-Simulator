package michlam.genshin_simulator_backend.controller;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.entity.BaseCharacter;
import michlam.genshin_simulator_backend.service.BaseCharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/base-characters") // Used to denote the base URL for any user-based apis.
public class BaseCharacterController {
    private BaseCharacterService baseCharacterService;

    // Build Get Base Characters API
    @GetMapping // Maps get to this method
    public ResponseEntity<List<BaseCharacterDto>> getBaseCharacters() {
        List<BaseCharacterDto> baseCharacterDtos = baseCharacterService.getBaseCharacters();
        return ResponseEntity.ok(baseCharacterDtos);
    }

}