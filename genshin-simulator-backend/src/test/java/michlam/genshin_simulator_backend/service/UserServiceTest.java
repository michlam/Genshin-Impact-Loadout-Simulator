package michlam.genshin_simulator_backend.service;

import michlam.genshin_simulator_backend.controller.UserController;
import michlam.genshin_simulator_backend.dto.UserCharacterDto;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.dto.UserTeamDto;
import michlam.genshin_simulator_backend.entity.User;
import michlam.genshin_simulator_backend.entity.UserTeam;
import michlam.genshin_simulator_backend.entity.keys.UserTeamKey;
import michlam.genshin_simulator_backend.exception.DuplicateResourceException;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.mapper.Mapper;
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
        userService.createUser(second);

        firstSaved.setUsername("test.user.2");
        Assertions.assertThrows(DuplicateResourceException.class, () -> userService.updateUser(firstSaved));
    }

    @Test
    void testUnlockUserCharacter_Success() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");
        UserDto savedUser = userService.createUser(userDto);

        UserCharacterDto userCharacterDto = userService.unlockUserCharacter(savedUser.getId(), "Amber");
        Assertions.assertEquals("Amber", userCharacterDto.getUserCharacterKey().getCharacter_name());
        Assertions.assertEquals(savedUser.getId(), userCharacterDto.getUserCharacterKey().getUser_id());
    }

    @Test
    void testUnlockUserCharacter_Failure_UserDoesNotExist() {
        Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> userService.unlockUserCharacter(1L, "Amber")
        );
    }

    @Test
    void testUnlockUserCharacter_Failure_CharacterDoesNotExist() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");
        UserDto savedUser = userService.createUser(userDto);

        Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> userService.unlockUserCharacter(savedUser.getId(), "Fake Character")
        );
    }

    @Test
    void testUnlockUserCharacter_Failure_AlreadyUnlocked() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");
        UserDto savedUser = userService.createUser(userDto);

        userService.unlockUserCharacter(savedUser.getId(), "Amber");

        Assertions.assertThrows(
                DuplicateResourceException.class,
                () -> userService.unlockUserCharacter(savedUser.getId(), "Amber")
        );
    }

    @Test
    void testGetUserCharactersById_Success() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");
        UserDto savedUser = userService.createUser(userDto);

        userService.unlockUserCharacter(savedUser.getId(), "Amber");
        userService.unlockUserCharacter(savedUser.getId(), "Barbara");

        List<String> userCharacters = userService.getUserCharactersById(savedUser.getId());
        Assertions.assertEquals(2, userCharacters.size());
        Assertions.assertEquals("Amber", userCharacters.get(0));
        Assertions.assertEquals("Barbara", userCharacters.get(1));
    }

    @Test
    void testGetUserCharactersById_Failure_UserDoesNotExist() {
        Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> userService.getUserById(1L)
        );
    }

    @Test
    void testGetIdByUsername_Success() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");
        UserDto savedUser = userService.createUser(userDto);

        Long id = userService.getIdByUsername(userDto.getUsername());
        Assertions.assertEquals(savedUser.getId(), id);
    }

    @Test
    void testGetIdByUsername_Failure_UserDoesNotExist() {
        Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> userService.getIdByUsername("test.user.fake")
        );
    }

    @Test
    void testGetUserTeamsById_Failure() {
        Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> userService.getUserTeamsById(1L)
        );
    }

    @Test
    void testUpdateUserTeam_Success() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");
        UserDto savedUser = userService.createUser(userDto);

        List<UserTeam> userTeams = userService.getUserTeamsById(savedUser.getId());
        UserTeam userTeam = userTeams.get(0);
        userTeam.setCharacter_name_1("Amber");
        userTeam.setCharacter_name_3("Lisa");

        UserTeamDto compareUserTeamDto = userService.updateUserTeam(Mapper.mapToUserTeamDto(userTeam));
        UserTeam compareUserTeam = Mapper.mapToUserTeam(compareUserTeamDto);
        Assertions.assertEquals(userTeam.getUserTeamKey().getTeam_num(), compareUserTeam.getUserTeamKey().getTeam_num());
        Assertions.assertEquals(userTeam.getUserTeamKey().getUser_id(), compareUserTeam.getUserTeamKey().getUser_id());
        Assertions.assertEquals(userTeam.getCharacter_name_1(), compareUserTeam.getCharacter_name_1());
        Assertions.assertEquals(userTeam.getCharacter_name_2(), compareUserTeam.getCharacter_name_2());
        Assertions.assertEquals(userTeam.getCharacter_name_3(), compareUserTeam.getCharacter_name_3());
        Assertions.assertEquals(userTeam.getCharacter_name_4(), compareUserTeam.getCharacter_name_4());

        userTeam.setCharacter_name_3(null);
        UserTeamDto compareUserTeamDto2 = userService.updateUserTeam(Mapper.mapToUserTeamDto(userTeam));
        UserTeam compareUserTeam2 = Mapper.mapToUserTeam(compareUserTeamDto2);
        Assertions.assertNull(compareUserTeam2.getCharacter_name_3());
    }

    @Test
    void testUpdateUserTeam_Failure_UserDoesNotExist() {
        UserTeamKey userTeamKey = new UserTeamKey(1L, 2);
        UserTeamDto userTeamDto = new UserTeamDto(userTeamKey, null, null, null, null);

        Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> userService.updateUserTeam(userTeamDto)
        );
    }

    @Test
    void testUpdateUserTeam_Failure_TeamNumDoesNotExist() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test.user.1");
        userDto.setPassword("1234");
        UserDto savedUser = userService.createUser(userDto);

        UserTeamKey userTeamKey = new UserTeamKey(savedUser.getId(), 50);
        UserTeamDto userTeamDto = new UserTeamDto(userTeamKey, null, null, null, null);

        Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> userService.updateUserTeam(userTeamDto)
        );
    }


}
