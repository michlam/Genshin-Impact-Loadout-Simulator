package michlam.genshin_simulator_backend.services;

import michlam.genshin_simulator_backend.controller.LoginController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {
    @Autowired
    private LoginController loginController;

    @Test
    void contextLoads() throws Exception {
        Assertions.assert
    }

//    @Test
//    public void testName() {
//        var result = service.isPalindrome("michael lam");
//        Assertions.assertFalse(result);
//    }
    //  Assertions.assertThrows()
    // Assertions.assertTrue;

}
