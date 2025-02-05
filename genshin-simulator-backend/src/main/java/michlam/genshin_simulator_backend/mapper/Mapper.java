package michlam.genshin_simulator_backend.mapper;

import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.entity.User;

public class Mapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto (
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User (
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword()
        );
    }
}
