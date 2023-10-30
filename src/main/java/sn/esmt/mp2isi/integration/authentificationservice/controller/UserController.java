package sn.esmt.mp2isi.integration.authentificationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn.esmt.mp2isi.integration.authentificationservice.model.User;
import sn.esmt.mp2isi.integration.authentificationservice.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/authenticate")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> authenticate (@RequestBody LoginRequest loginRequest) {
        Optional<User> optionalUser = userService.authenticate(loginRequest.getLogin(), loginRequest.getPassword());
        if(optionalUser.isPresent()) {
            return ResponseEntity.ok(new ResponseWrapper(HttpStatus.OK.value(), "Authentication Successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseWrapper(HttpStatus.UNAUTHORIZED.value(), "Authentication failed"));
        }
    }
}
