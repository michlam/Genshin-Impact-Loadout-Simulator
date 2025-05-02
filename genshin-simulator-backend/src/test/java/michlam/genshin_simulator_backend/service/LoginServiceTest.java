package michlam.genshin_simulator_backend.service;

import michlam.genshin_simulator_backend.controller.LoginController;
import michlam.genshin_simulator_backend.entity.User;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class LoginServiceTest {
    @Autowired
    private LoginController loginController;

    @Autowired
    private LoginService loginService;

    @Test
    void contextLoads() throws Exception {
        Assertions.assertNotNull(loginController);
    }

    @Test
    void testLogin_BasicSuccess() {
        String username = "test.user";
        String password = "1234";

        Assertions.assertTrue(loginService.login(username, password));
    }

    @Test
    void testLogin_IncorrectPassword() {
        String username = "test.user";
        String password = "1235";

        Assertions.assertFalse(loginService.login(username, password));
    }

    @Test
    void testLogin_IncorrectUsername() {
        String username = "test.user.doesnt.exist";
        String password = "1234";

        Assertions.assertThrows(ResourceNotFoundException.class, () -> loginService.login(username, password));
    }

//    public class LoginServiceImpl implements LoginService {
//        private UserRepository userRepository;
//        private PasswordEncoder passwordEncoder;
//
//        @Override
//        public boolean login(String username, String password) {
//            User user = userRepository.findByUsername(username).orElseThrow(() ->
//                    new ResourceNotFoundException("User does not exist with the given username: " + username));
//
//            return passwordEncoder.matches(password, user.getPassword());
//        }
//    }

}
