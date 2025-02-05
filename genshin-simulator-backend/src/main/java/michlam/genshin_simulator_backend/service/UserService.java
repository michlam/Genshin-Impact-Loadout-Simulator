package michlam.genshin_simulator_backend.service;

import michlam.genshin_simulator_backend.dto.UserDto;

public interface UserService{
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
}
