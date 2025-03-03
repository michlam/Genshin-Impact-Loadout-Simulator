package michlam.genshin_simulator_backend.service.impl;

import lombok.AllArgsConstructor;
import michlam.genshin_simulator_backend.entity.User;
import michlam.genshin_simulator_backend.exception.ResourceNotFoundException;
import michlam.genshin_simulator_backend.mapper.Mapper;
import michlam.genshin_simulator_backend.repository.UserRepository;
import michlam.genshin_simulator_backend.service.LoginService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {
    private UserRepository userRepository;

    @Override
    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new ResourceNotFoundException("User does not exist with the given username: " + username));

        return password.equals(user.getPassword());
    }
}
