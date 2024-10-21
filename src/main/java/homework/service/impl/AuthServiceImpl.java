package homework.service.impl;

import homework.config.security.UserDetailsConfig;
import homework.dto.security.AuthRequest;
import homework.dto.security.AuthResponse;
import homework.entity.UserCredential;
import homework.repository.api.RoleRepository;
import homework.repository.api.UserCredentialRepository;
import homework.security.JwtService;
import homework.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserCredentialRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
        UserCredential user = Optional.ofNullable(userRepository.findLogin(authRequest.getLogin())).orElseThrow();
        String jwtToken = jwtService.generateToken(new UserDetailsConfig(user));

        return AuthResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthResponse reg(AuthRequest authRequest) {
        var clientRole = roleRepository.findByRoleName("user");

        UserCredential user = UserCredential.builder()
                .username(authRequest.getLogin())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .roles(clientRole)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(new UserDetailsConfig(user));

        return AuthResponse.builder().token(jwtToken).build();
    }
}
