package homework.service;

import homework.dto.security.AuthRequest;
import homework.dto.security.AuthResponse;

public interface AuthService {
    AuthResponse authenticate(AuthRequest authRequest);
    AuthResponse reg(AuthRequest authRequest);
}
