package michlam.genshin_simulator_backend;

import michlam.genshin_simulator_backend.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {
    @Autowired
    private LoginController loginController;

    @Test
    void contextLoads() throws Exception {
    }

}
