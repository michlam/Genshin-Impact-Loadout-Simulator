package michlam.genshin_simulator_backend.service.impl;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.dto.BaseWeaponDto;
import michlam.genshin_simulator_backend.entity.BaseCharacter;
import michlam.genshin_simulator_backend.entity.BaseWeapon;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.mapper.Mapper;
import michlam.genshin_simulator_backend.repository.BaseCharacterRepository;
import michlam.genshin_simulator_backend.repository.BaseWeaponRepository;
import michlam.genshin_simulator_backend.service.BaseWeaponService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BaseWeaponServiceImpl implements BaseWeaponService {
    private BaseWeaponRepository baseWeaponRepository;

    @Override
    public List<BaseWeaponDto> getBaseWeapons() {
        List<BaseWeapon> baseWeapons = baseWeaponRepository.findAll();
        List<BaseWeaponDto> baseWeaponDtos = new ArrayList<>();

        for (BaseWeapon baseWeapon : baseWeapons) {
            baseWeaponDtos.add(Mapper.mapToBaseWeaponDto(baseWeapon));
        }

        return baseWeaponDtos;
    }

    @Override
    public BaseWeaponDto getBaseWeaponByName(String name) {
        BaseWeapon baseWeapon = baseWeaponRepository.findByName(name).orElseThrow(() ->
                new ResourceNotFoundException("Base weapon does not exist with the given name: " + name));

        return Mapper.mapToBaseWeaponDto(baseWeapon);
    }
}
