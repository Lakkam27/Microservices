package com.lakkam.Contoler;

import com.lakkam.DTO.LoginDto;
import com.lakkam.DTO.SignUpDto;
import com.lakkam.Entity.Role;
import com.lakkam.Entity.User;
import com.lakkam.Repository.RoleRepository;
import com.lakkam.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        String username = loginDto.getEmail();
        String password = loginDto.getPassword();

        if (userRepository.findByEmail(username).isPresent()) {
            if (userRepository.findByPassword(password).isPresent()) {
                return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Enter correct password!.", HttpStatus.OK);

            }


        } else {
            return new ResponseEntity<>("Please signup first !.", HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpDto signUpDto) {

        // add check for username exists in a DB
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(signUpDto.getPassword());

        Role roles = roleRepository.findByName("ROLE_ADMIN").orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}