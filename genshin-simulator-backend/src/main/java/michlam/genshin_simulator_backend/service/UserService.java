package michlam.genshin_simulator_backend.service;

import michlam.genshin_simulator_backend.dto.UserCharacterDto;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.entity.UserTeam;

import java.util.List;

public interface UserService{
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    UserDto updateUser(UserDto updatedUser);

    UserCharacterDto unlockUserCharacter(Long userId, String name);
    List<String> getUserCharactersById(Long userId);

    Long getIdByUsername(String username);

    List<UserTeam> getUserTeamsById(Long userId);
}
