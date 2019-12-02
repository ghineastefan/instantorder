package com.softdight.instantorder.backend.controller;

import com.softdight.instantorder.backend.jwt.JwtTokenProvider;
import com.softdight.instantorder.backend.model.Role;
import com.softdight.instantorder.backend.model.User;
import com.softdight.instantorder.backend.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;

@RestController
@RequestMapping("/public")
public class PublicRestController {

    private static final Logger LOGGER = LogManager.getLogger(PublicRestController.class);

    private UserService userService;
    private JwtTokenProvider tokenProvider;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public PublicRestController(UserService userService, JwtTokenProvider tokenProvider, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    @ApiOperation(
            value = "Add a new user.",
            notes = "The added user will have the default role 'USER'. The Id, Role and Token fields are optional here.",
            response = User.class)
    public ResponseEntity<?> register(@RequestBody @ApiParam(required = true) User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            throw new BadCredentialsException("Username already exists!");
        }

        user.setId(null);
        user.setToken(null);
        user.setRole(Role.USER);

        User userSaved = userService.saveUser(user);

        userSaved.setPassword(null);

        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }

    @GetMapping("/login")
    @ApiOperation(
            value = "Login with an username and password.",
            notes = "Will generate a token, which will be attached to the next requests for authorization.",
            response = User.class)
    public ResponseEntity<?> login(@RequestHeader("username") @ApiParam(required = true, example = "George") final String username,
                                   @RequestHeader("password") @ApiParam(required = true, example = "Parola123@") final String password) {
        final User user = userService.findByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            final String token = tokenProvider.generateToken(new UsernamePasswordAuthenticationToken(username, password, Collections.singletonList(user.getRole())));
            user.setToken(token);
            user.setPassword(null);

            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            throw new BadCredentialsException("Invalid credentials!");
        }
    }

    @PostMapping("/logout")
    @ApiOperation(
            value = "Logs out the current user.")
    public ResponseEntity<?> logout(@RequestBody @ApiParam(required = true, example = "George") final String username) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
