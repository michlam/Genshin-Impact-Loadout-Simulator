package michlam.genshin_simulator_backend.service;

import michlam.genshin_simulator_backend.dto.BaseWeaponDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BaseWeaponServiceTest {
//    @Autowired
//    private BaseWeaponController baseWeaponController;

    @Autowired
    private BaseWeaponService baseWeaponService;

//    @Test
//    void contextLoads() throws Exception {
//        Assertions.assertNotNull(baseCharacterController);
//    }

    @Test
    void testGetBaseWeapons() {
        List<BaseWeaponDto> baseWeaponDtos = baseWeaponService.getBaseWeapons();

        for (BaseWeaponDto currWeapon : baseWeaponDtos) {
            BaseWeaponDto baseWeapon = baseWeaponService.getBaseWeaponByName(currWeapon.getName());

            Assertions.assertEquals(baseWeapon.getName(), currWeapon.getName());
            Assertions.assertEquals(baseWeapon.getStar(), currWeapon.getStar());
            Assertions.assertEquals(baseWeapon.getAttack(), currWeapon.getAttack());
            Assertions.assertEquals(baseWeapon.getType(), currWeapon.getType());
            Assertions.assertEquals(baseWeapon.getSecondary(), currWeapon.getSecondary());
            Assertions.assertEquals(baseWeapon.getPassive_name(), currWeapon.getPassive_name());
            Assertions.assertEquals(baseWeapon.getPassive_text(), currWeapon.getPassive_text());
        }
    }

    @Test
    void testGetBaseWeaponsByName_AmosBow() {
        
    }

    @Test
    void testGetBaseWeaponsByName_FavoniusSword() {

    }

    @Test
    void testGetBaseWeaponsByName_ThrillingTalesOfDragonSlayers() {

    }

}
