package michlam.genshin_simulator_backend.service;

import michlam.genshin_simulator_backend.controller.AuthenticationRequest;
import michlam.genshin_simulator_backend.controller.AuthenticationResponse;
import michlam.genshin_simulator_backend.controller.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
