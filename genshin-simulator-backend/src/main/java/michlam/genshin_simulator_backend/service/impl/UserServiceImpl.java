package michlam.genshin_simulator_backend.service.impl;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.dto.UserDto;
import michlam.genshin_simulator_backend.entity.User;
import michlam.genshin_simulator_backend.exception.DuplicateResourceException;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.mapper.Mapper;
import michlam.genshin_simulator_backend.repository.UserRepository;
import michlam.genshin_simulator_backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

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
}
