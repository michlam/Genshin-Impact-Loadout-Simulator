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
        BaseWeaponDto amosBow = baseWeaponService.getBaseWeaponByName("Amos Bow");

        Assertions.assertEquals("Amos Bow", amosBow.getName());
        Assertions.assertEquals(5, amosBow.getStar());
        Assertions.assertEquals(608, amosBow.getAttack());
        Assertions.assertEquals("Bow", amosBow.getType());
        Assertions.assertEquals("ATK", amosBow.getSecondary());
        Assertions.assertEquals("", amosBow.getPassive_name());
        Assertions.assertEquals("", amosBow.getPassive_text());
    }

    @Test
    void testGetBaseWeaponsByName_FavoniusSword() {
        BaseWeaponDto favSword = baseWeaponService.getBaseWeaponByName("Favonius Sword");

        Assertions.assertEquals("Favonius Sword", favSword.getName());
        Assertions.assertEquals(4, favSword.getStar());
        Assertions.assertEquals(454, favSword.getAttack());
        Assertions.assertEquals("Sword", favSword.getType());
        Assertions.assertEquals("Energy Recharge", favSword.getSecondary());
        Assertions.assertEquals("", favSword.getPassive_name());
        Assertions.assertEquals("", favSword.getPassive_text());
    }

    @Test
    void testGetBaseWeaponsByName_ThrillingTalesOfDragonSlayers() {
        BaseWeaponDto thrillingTales = baseWeaponService.getBaseWeaponByName("Thrilling Tales of Dragon Slayers");

        Assertions.assertEquals("Thrilling Tales of Dragon Slayers", thrillingTales.getName());
        Assertions.assertEquals(3, thrillingTales.getStar());
        Assertions.assertEquals(401, thrillingTales.getAttack());
        Assertions.assertEquals("Catalyst", thrillingTales.getType());
        Assertions.assertEquals("HP", thrillingTales.getSecondary());
        Assertions.assertEquals("", thrillingTales.getPassive_name());
        Assertions.assertEquals("", thrillingTales.getPassive_text());
    }

}
