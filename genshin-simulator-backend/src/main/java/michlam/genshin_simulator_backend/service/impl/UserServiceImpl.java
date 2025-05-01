package michlam.genshin_simulator_backend.service.impl;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.dto.UserCharacterDto;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.dto.UserTeamDto;
import michlam.genshin_simulator_backend.entity.*;
import michlam.genshin_simulator_backend.entity.keys.UserCharacterKey;
import michlam.genshin_simulator_backend.entity.keys.UserTeamKey;
import michlam.genshin_simulator_backend.exception.DuplicateResourceException;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.mapper.Mapper;
import michlam.genshin_simulator_backend.repository.BaseCharacterRepository;
import michlam.genshin_simulator_backend.repository.UserCharacterRepository;
import michlam.genshin_simulator_backend.repository.UserRepository;
import michlam.genshin_simulator_backend.repository.UserTeamRepository;
import michlam.genshin_simulator_backend.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BaseCharacterRepository baseCharacterRepository;
    private UserCharacterRepository userCharacterRepository;
    private UserTeamRepository userTeamRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = Mapper.mapToUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new DuplicateResourceException("Username is already taken");
        }

        User savedUser = userRepository.save(user);
        // Initialize all user teams for this user
        for (int i = 1; i <= 8; i++) {
            UserTeamKey userTeamKey = new UserTeamKey(user.getId(), i);
            UserTeam userTeam = new UserTeam(userTeamKey,
                    null, null, null, null);
            userTeamRepository.save(userTeam);
        }

        return Mapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User does not exist with the given id: " + userId));
        return Mapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto updatedUser) {
        User user = userRepository.findById(updatedUser.getId()).orElseThrow(() ->
                new ResourceNotFoundException("User does not exist with the given id: " + updatedUser.getId()));

        // Check that we aren't changing the username to something that is taken.
        userRepository.findByUsername(updatedUser.getUsername()).ifPresent(checkUser -> {
                if (!checkUser.getId().equals(updatedUser.getId())) {
                    throw new DuplicateResourceException("User with this username is already taken.");
                }
        });

        user.setUsername(updatedUser.getUsername());
        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

        User updatedUserObj = userRepository.save(user);
        updatedUserObj.setPassword(updatedUser.getPassword());
        return Mapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public UserCharacterDto unlockUserCharacter(Long userId, String name) {
        userRepository.findById(userId).orElseThrow(() ->
            new ResourceNotFoundException("User does not exist with the given id: " + userId));

        baseCharacterRepository.findByName(name).orElseThrow(() ->
            new ResourceNotFoundException("Base character does not exist with the given name: " + name));

        if (userCharacterRepository.findCharactersById(userId).contains(name)) {
            throw new DuplicateResourceException("User " + userId + " has already unlocked the character " + name);
        }

        UserCharacterKey userCharacterKey = new UserCharacterKey(userId, name);
        UserCharacter userCharacter = new UserCharacter(userCharacterKey);
        userCharacterRepository.save(userCharacter);

        return Mapper.mapToUserCharacterDto(userCharacter);
    }

    @Override
    public List<String> getUserCharactersById(Long userId) {
        userRepository.findById(userId).orElseThrow(() ->
            new ResourceNotFoundException("User does not exist with the given id: " + userId));

        return userCharacterRepository.findCharactersById(userId);
    }

    @Override
    public Long getIdByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
            new ResourceNotFoundException("User does not exist with the given username: " + username));

        return user.getId();
    }

    @Override
    public List<UserTeam> getUserTeamsById(Long userId) {
        userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User does not exist with the given id: " + userId));

        return userTeamRepository.findTeamsById(userId);
    }

    @Override
    public UserTeamDto updateUserTeam(UserTeamDto userTeamDto) {
        UserTeamKey userTeamKey = userTeamDto.getUserTeamKey();
        Long userId = userTeamKey.getUser_id();
        Integer teamNum = userTeamKey.getTeam_num();

        try {
            UserTeam userTeam = userTeamRepository.findTeamByIdAndNum(userId, teamNum);
            userTeam.setCharacter_name_1(userTeamDto.getCharacter_name_1());
            userTeam.setCharacter_name_2(userTeamDto.getCharacter_name_2());
            userTeam.setCharacter_name_3(userTeamDto.getCharacter_name_3());
            userTeam.setCharacter_name_4(userTeamDto.getCharacter_name_4());

            UserTeam updatedUserTeamObj = userTeamRepository.save(userTeam);
            return Mapper.mapToUserTeamDto(updatedUserTeamObj);
        } catch (Exception e) {
            throw new ResourceNotFoundException("There was an error finding this team.");
        }
    }
}