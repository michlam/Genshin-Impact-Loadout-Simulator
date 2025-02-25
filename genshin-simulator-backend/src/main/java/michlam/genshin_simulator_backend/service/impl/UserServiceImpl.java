package michlam.genshin_simulator_backend.service.impl;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.BaseCharacterDto;
import michlam.genshin_simulator_backend.dto.UserCharacterDto;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.entity.BaseCharacter;
import michlam.genshin_simulator_backend.entity.User;
import michlam.genshin_simulator_backend.entity.UserCharacter;
import michlam.genshin_simulator_backend.entity.keys.UserCharacterKey;
import michlam.genshin_simulator_backend.exception.DuplicateResourceException;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.mapper.Mapper;
import michlam.genshin_simulator_backend.repository.BaseCharacterRepository;
import michlam.genshin_simulator_backend.repository.UserCharacterRepository;
import michlam.genshin_simulator_backend.repository.UserRepository;
import michlam.genshin_simulator_backend.service.UserService;
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

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = Mapper.mapToUser(userDto);
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new DuplicateResourceException("Username is already taken");
        }

        User savedUser = userRepository.save(user);
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
        user.setPassword(updatedUser.getPassword()); // In the future, probably don't want to it this way.

        User updatedUserObj = userRepository.save(user);
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

}