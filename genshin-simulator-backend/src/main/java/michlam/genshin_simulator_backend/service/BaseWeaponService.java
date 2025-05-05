package michlam.genshin_simulator_backend.service;

import michlam.genshin_simulator_backend.dto.BaseWeaponDto;
import java.util.List;

public interface BaseWeaponService {
    List<BaseWeaponDto> getBaseWeapons();
    BaseWeaponDto getBaseWeaponByName(String name);
}
