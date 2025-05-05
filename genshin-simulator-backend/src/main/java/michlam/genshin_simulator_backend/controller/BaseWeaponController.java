package michlam.genshin_simulator_backend.controller;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.dto.BaseWeaponDto;
import michlam.genshin_simulator_backend.exception.ErrorResponse;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.service.BaseCharacterService;
import michlam.genshin_simulator_backend.service.BaseWeaponService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from this origin
public class BaseWeaponController {
    private BaseWeaponService baseWeaponService;

    // Build Get Base Weapons API
    @GetMapping("/api/base-weapons")
    public ResponseEntity<List<BaseWeaponDto>> getBaseWeapons() {
        List<BaseWeaponDto> baseWeaponDtos = baseWeaponService.getBaseWeapons();
        return ResponseEntity.ok(baseWeaponDtos);
    }

    // Build Get Base Weapon By Name API
    @GetMapping("/api/base-weapons/{name}")
    public ResponseEntity<Object> getBaseWeaponByName(@PathVariable String name) {
        try {
            BaseWeaponDto baseWeaponDto = baseWeaponService.getBaseWeaponByName(name);
            return ResponseEntity.ok(baseWeaponDto);
        } catch (ResourceNotFoundException e) {
            ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}