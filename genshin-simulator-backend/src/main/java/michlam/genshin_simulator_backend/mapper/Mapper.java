package michlam.genshin_simulator_backend.mapper;

import michlam.genshin_simulator_backend.dto.*;
import michlam.genshin_simulator_backend.entity.*;
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
                userDto.getPassword(),
                Role.USER
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

    public static BaseWeaponDto mapToBaseWeaponDto(BaseWeapon baseWeapon) {
        return new BaseWeaponDto(
                baseWeapon.getName(),
                baseWeapon.getType(),
                baseWeapon.getStar(),
                baseWeapon.getAttack(),
                baseWeapon.getSecondary(),
                baseWeapon.getPassive_name(),
                baseWeapon.getPassive_text()
        );
    }

    public static BaseWeapon mapToBaseWeapon(BaseWeaponDto baseWeaponDto) {
        return new BaseWeapon(
                baseWeaponDto.getName(),
                baseWeaponDto.getType(),
                baseWeaponDto.getStar(),
                baseWeaponDto.getAttack(),
                baseWeaponDto.getSecondary(),
                baseWeaponDto.getPassive_name(),
                baseWeaponDto.getPassive_text()
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