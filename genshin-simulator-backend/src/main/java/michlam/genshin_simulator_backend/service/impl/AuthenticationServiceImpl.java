package michlam.genshin_simulator_backend.service.impl;

import lombok.RequiredArgsConstructor;
import michlam.genshin_simulator_backend.config.JwtService;
import michlam.genshin_simulator_backend.controller.AuthenticationRequest;
import michlam.genshin_simulator_backend.controller.AuthenticationResponse;
import michlam.genshin_simulator_backend.controller.RegisterRequest;
import michlam.genshin_simulator_backend.entity.Role;
import michlam.genshin_simulator_backend.repository.UserRepository;
import michlam.genshin_simulator_backend.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        return null;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
             .token(jwtToken)
             .build();

    }
}
