package michlam.genshin_simulator_backend.service;

import io.jsonwebtoken.lang.Assert;
import michlam.genshin_simulator_backend.controller.BaseCharacterController;
import michlam.genshin_simulator_backend.controller.UserController;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertNotNull(userController);
    }

    @Test
    void testCreateUser_BasicSuccess() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");

        // Check the return userDto is good
        UserDto savedUser = userService.createUser(userDto);
        Assertions.assertEquals(userDto.getUsername(), savedUser.getUsername());
        Assertions.assertEquals(userDto.getPassword(), savedUser.getPassword());
    }

//    void testLogin_BasicSuccess() {
//        String username = "test.user";
//        String password = "1234";
//
//        Assertions.assertTrue(loginService.login(username, password));
//    }
}
