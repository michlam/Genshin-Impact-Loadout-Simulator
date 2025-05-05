package michlam.genshin_simulator_backend.service.impl;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.dto.BaseWeaponDto;
import michlam.genshin_simulator_backend.entity.BaseCharacter;
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

        return List.of();
//
//        List<BaseCharacter> baseCharacters = baseCharacterRepository.findAll();
//        List<BaseCharacterDto> baseCharacterDtos = new ArrayList<BaseCharacterDto>();
//
//        for (BaseCharacter baseCharacter : baseCharacters) {
//            baseCharacterDtos.add(Mapper.mapToBaseCharacterDto(baseCharacter));
//        }
//
//        return baseCharacterDtos;
    }

    @Override
    public BaseWeaponDto getBaseWeaponByName(String name) {
        return null;
    }
}
