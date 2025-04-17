package quizcheat.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import quizcheat.backend.dto.response.StatusResponse;
import quizcheat.backend.dto.response.UserResponse;
import quizcheat.backend.entity.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quizcheat.backend.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/me")
    public ResponseEntity<StatusResponse> me() {
        String email = "shydev@gmail.com";

        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            return new ResponseEntity<>(new StatusResponse<User>("Error!", new User()), HttpStatus.BAD_REQUEST);
        }
        User tmp = user.get();
        UserResponse userRespones = new UserResponse(tmp.getEmail(), tmp.getRole(), tmp.getName());
        return new ResponseEntity<>(new StatusResponse<>("Success", userRespones), HttpStatus.OK);
    }

}
