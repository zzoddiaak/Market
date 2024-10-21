package homework.controller;

import homework.dto.security.AuthRequest;
import homework.dto.security.AuthResponse;
import homework.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resource-controller")
@RequiredArgsConstructor
public class ResourceController {
    private final AuthService authService;


    @PostMapping("/login")
    public AuthResponse loginEndpoint(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }

    @PostMapping("/reg")
    public AuthResponse registerEndpoint(@RequestBody AuthRequest authRequest) {
        return authService.reg(authRequest);
    }

}


