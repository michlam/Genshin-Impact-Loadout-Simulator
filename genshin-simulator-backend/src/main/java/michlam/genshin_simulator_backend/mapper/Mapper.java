package michlam.genshin_simulator_backend.mapper;

import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.dto.UserCharacterDto;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.dto.UserTeamDto;
import michlam.genshin_simulator_backend.entity.BaseCharacter;
import michlam.genshin_simulator_backend.entity.User;
import michlam.genshin_simulator_backend.entity.UserCharacter;
import michlam.genshin_simulator_backend.entity.UserTeam;
import michlam.genshin_simulator_backend.entity.keys.UserTeamKey;

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

    public static BaseCharacterDto mapToBaseCharacterDto(BaseCharacter baseCharacter) {
        return new BaseCharacterDto(
                baseCharacter.getName(),
                baseCharacter.getTitle(),
                baseCharacter.getStar(),
                baseCharacter.getElement(),
                baseCharacter.getWeapon_type()
        );
    }
    public static BaseCharacter mapToBaseCharacter(BaseCharacterDto baseCharacterDto) {
        return new BaseCharacter(
                baseCharacterDto.getName(),
                baseCharacterDto.getTitle(),
                baseCharacterDto.getStar(),
                baseCharacterDto.getElement(),
                baseCharacterDto.getWeapon_type()
        );
    }
    
    public static UserCharacterDto mapToUserCharacterDto(UserCharacter userCharacter) {
        return new UserCharacterDto(
                userCharacter.getUserCharacterKey()
        );
    }
    public static UserCharacter mapToUserCharacter(UserCharacterDto userCharacterDto) {
        return new UserCharacter(
                userCharacterDto.getUserCharacterKey()
        );
    }

    public static UserTeamDto mapToUserTeamDto(UserTeam userTeam) {
        return new UserTeamDto(
                userTeam.getUserTeamKey(),
                userTeam.getCharacter_name_1(),
                userTeam.getCharacter_name_2(),
                userTeam.getCharacter_name_3(),
                userTeam.getCharacter_name_4()
        );
    }
    public static UserTeam mapToUserTeam(UserTeamDto userTeamDto) {
        return new UserTeam(
                userTeamDto.getUserTeamKey(),
                userTeamDto.getCharacter_name_1(),
                userTeamDto.getCharacter_name_2(),
                userTeamDto.getCharacter_name_3(),
                userTeamDto.getCharacter_name_4()
        );
    }
}