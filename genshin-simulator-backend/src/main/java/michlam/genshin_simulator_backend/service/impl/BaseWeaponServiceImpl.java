package michlam.genshin_simulator_backend.service.impl;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.BaseWeaponDto;
import michlam.genshin_simulator_backend.repository.BaseCharacterRepository;
import michlam.genshin_simulator_backend.repository.BaseWeaponRepository;
import michlam.genshin_simulator_backend.service.BaseWeaponService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BaseWeaponServiceImpl implements BaseWeaponService {
    private BaseWeaponRepository baseWeaponRepository;

    @Override
    public List<BaseWeaponDto> getBaseWeapons() {
        return List.of();
    }

    @Override
    public BaseWeaponDto getBaseWeaponByName(String name) {
        return null;
    }
}
