package michlam.genshin_simulator_backend.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.jsonwebtoken.lang.Assert;
import michlam.genshin_simulator_backend.controller.BaseCharacterController;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BaseCharacterServiceTest {
    @Autowired
    private BaseCharacterController baseCharacterController;

    @Autowired
    private BaseCharacterService baseCharacterService;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertNotNull(baseCharacterController);
    }

    @Test
    void testGetBaseCharacters() {
        List<BaseCharacterDto> baseCharacterDtos = baseCharacterService.getBaseCharacters();

        for (BaseCharacterDto currChar : baseCharacterDtos) {
            BaseCharacterDto baseChar = baseCharacterService.getBaseCharacterByName(currChar.getName());

            Assertions.assertEquals(baseChar.getName(), currChar.getName());
            Assertions.assertEquals(baseChar.getStar(), currChar.getStar());
            Assertions.assertEquals(baseChar.getElement(), currChar.getElement());
            Assertions.assertEquals(baseChar.getTitle(), currChar.getTitle());
            Assertions.assertEquals(baseChar.getWeapon_type(), currChar.getWeapon_type());
        }
    }

    @Test
    void testGetBaseCharactersByName_Amber() {
        BaseCharacterDto amber = baseCharacterService.getBaseCharacterByName("Amber");

        Assertions.assertEquals("Amber", amber.getName());
        Assertions.assertEquals(4, amber.getStar());
        Assertions.assertEquals("Pyro", amber.getElement());
        Assertions.assertEquals("Gliding Champion", amber.getTitle());
        Assertions.assertEquals("Bow", amber.getWeapon_type());
    }

    @Test
    void testGetBaseCharactersByName_Fischl() {
        BaseCharacterDto fischl = baseCharacterService.getBaseCharacterByName("Fischl");

        Assertions.assertEquals("Fischl", fischl.getName());
        Assertions.assertEquals(4, fischl.getStar());
        Assertions.assertEquals("Electro", fischl.getElement());
        Assertions.assertEquals("Prinzessin der Verurteilung!", fischl.getTitle());
        Assertions.assertEquals("Bow", fischl.getWeapon_type());
    }

    @Test
    void testGetBaseCharactersByName_Xiangling() {
        BaseCharacterDto xiangling = baseCharacterService.getBaseCharacterByName("Xiangling");

        Assertions.assertEquals("Xiangling", xiangling.getName());
        Assertions.assertEquals(4, xiangling.getStar());
        Assertions.assertEquals("Pyro", xiangling.getElement());
        Assertions.assertEquals("Exquisite Delicacy", xiangling.getTitle());
        Assertions.assertEquals("Polearm", xiangling.getWeapon_type());
    }

    @Test
    void testGetBaseCharactersByName_CharDoesNotExist() {
        Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> baseCharacterService.getBaseCharacterByName("FakeCharacter")
        );
    }

}
