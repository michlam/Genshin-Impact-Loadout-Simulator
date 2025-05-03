package michlam.genshin_simulator_backend.service;

import michlam.genshin_simulator_backend.controller.BaseCharacterController;
import michlam.genshin_simulator_backend.controller.UserController;
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
    
}
