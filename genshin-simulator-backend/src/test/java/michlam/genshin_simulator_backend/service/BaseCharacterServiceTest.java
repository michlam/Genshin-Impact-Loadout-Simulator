package michlam.genshin_simulator_backend.service;

import michlam.genshin_simulator_backend.controller.BaseCharacterController;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
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

}
