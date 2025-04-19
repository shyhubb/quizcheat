package quizcheat.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quizcheat.backend.config.JwtTokenProvider;
import quizcheat.backend.dto.request.LoginRequest;
import quizcheat.backend.dto.request.RegisterRequest;
import quizcheat.backend.dto.response.LoginResponse;
import quizcheat.backend.dto.response.RegisterResponse;
import quizcheat.backend.dto.response.StatusResponse;
import quizcheat.backend.service.impl.AuthServiceimpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private AuthServiceimpl authServiceimpl;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<StatusResponse> Login(@RequestBody LoginRequest loginRequest) {
        String status = authServiceimpl.Login(loginRequest.getEmail(), loginRequest.getPassword());
        if (status.equals("Login successful!")) {
            String role = authServiceimpl.findRoleByEmail(loginRequest.getEmail());
            String token = jwtTokenProvider.generateToken(loginRequest.getEmail(), role);
            System.out.println("token: " + token);
            return new ResponseEntity<>(new StatusResponse(status, new LoginResponse(token)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new StatusResponse(status, new LoginResponse()), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> Register(@RequestBody RegisterRequest registerRequest) {
        String status = authServiceimpl.register(registerRequest.getEmail(), registerRequest.getPassword(),
                registerRequest.getCheckpassword(), registerRequest.getName());
        if (status.equals("Register successful , Please login!")) {
            return new ResponseEntity<>(new RegisterResponse(status), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new RegisterResponse(status), HttpStatus.BAD_REQUEST);

    }

}
