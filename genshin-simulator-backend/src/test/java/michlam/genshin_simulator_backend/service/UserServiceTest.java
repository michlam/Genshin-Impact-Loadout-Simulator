package michlam.genshin_simulator_backend.service;

import io.jsonwebtoken.lang.Assert;
import michlam.genshin_simulator_backend.controller.BaseCharacterController;
import michlam.genshin_simulator_backend.controller.UserController;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.entity.User;
import michlam.genshin_simulator_backend.entity.UserTeam;
import michlam.genshin_simulator_backend.exception.DuplicateResourceException;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.repository.UserCharacterRepository;
import michlam.genshin_simulator_backend.repository.UserRepository;
import michlam.genshin_simulator_backend.repository.UserTeamRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTeamRepository userTeamRepository;

    @Autowired
    private UserCharacterRepository userCharacterRepository;

    @BeforeEach
    void setUp() {
        userTeamRepository.testDeleteUserTeams();
        userCharacterRepository.testDeleteUserCharacters();
        userRepository.testDeleteUsers();
    }

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

        // Check the eight user teams are created and correct
        List<UserTeam> userTeams = userService.getUserTeamsById(savedUser.getId());
        Assertions.assertEquals(8, userTeams.size());
        Assertions.assertEquals(savedUser.getId(), userTeams.get(0).getUserTeamKey().getUser_id());
        Assertions.assertEquals(1, userTeams.get(0).getUserTeamKey().getTeam_num());
        Assertions.assertEquals(8, userTeams.get(7).getUserTeamKey().getTeam_num());
        Assertions.assertNull(userTeams.get(0).getCharacter_name_1());
        Assertions.assertNull(userTeams.get(0).getCharacter_name_2());
        Assertions.assertNull(userTeams.get(0).getCharacter_name_3());
        Assertions.assertNull(userTeams.get(0).getCharacter_name_4());
    }

    @Test
    void testCreateUser_Fail_UsernameExists() {
        UserDto first = new UserDto();
        first.setUsername("test.user.1");
        first.setPassword("1234");

        UserDto second = new UserDto();
        second.setUsername("test.user.1");
        second.setPassword("2345");

        userService.createUser(first);
        Assertions.assertThrows(DuplicateResourceException.class, () -> userService.createUser(second));
    }

    @Test
    void testGetUserById_Success() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");

        UserDto savedUser = userService.createUser(userDto);
        UserDto compareUser = userService.getUserById(savedUser.getId());

        Assertions.assertEquals(savedUser.getId(), compareUser.getId());
        Assertions.assertEquals(savedUser.getUsername(), compareUser.getUsername());
    }

    @Test
    void testGetUserById_Failure_UserDoesNotExist() {
        Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.getUserById(1L));
    }

    @Test
    void testUpdateUser_Success() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");

        UserDto savedUser = userService.createUser(userDto);
        savedUser.setUsername("test.user.2");
        savedUser.setPassword("2345");

        UserDto compareUser = userService.updateUser(savedUser);
        Assertions.assertEquals(savedUser.getId(), compareUser.getId());
        Assertions.assertEquals(savedUser.getUsername(), compareUser.getUsername());
        Assertions.assertEquals(savedUser.getPassword(), compareUser.getPassword());
    }

    @Test
    void testUpdateUser_Failure_UserDoesNotExist() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");

        UserDto fakeUser = new UserDto(1L, "test.user.2", "2345");

        Assertions.assertThrows(ResourceNotFoundException.class, () -> userService.updateUser(fakeUser));
    }

    @Test
    void testUpdateUser_Failure_UsernameExists() {
        UserDto first = new UserDto();
        first.setUsername("test.user.1");
        first.setPassword("1234");
        UserDto firstSaved = userService.createUser(first);

        UserDto second = new UserDto();
        second.setUsername("test.user.2");
        second.setPassword("2345");
        UserDto secondSaved = userService.createUser(second);

        firstSaved.setUsername("test.user.2");
        Assertions.assertThrows(DuplicateResourceException.class, () -> userService.updateUser(firstSaved));
    }
}
