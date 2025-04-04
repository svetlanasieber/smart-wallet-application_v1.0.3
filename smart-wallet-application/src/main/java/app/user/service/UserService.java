package app.user.service;

import app.exception.DomainException;
import app.user.model.User;
import app.user.repository.UserRepository;
import app.web.dto.RegisterRequest;

import com.fasterxml.jackson.databind.introspect.AnnotationCollector;
import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest registerRequest) {

        Optional<User> userOptional = userRepository.findByUsername(registerRequest.getUsername());
        if (userOptional.isPresent()) {
            throw new DomainException("Username [%s] already exist." .formatted(registerRequest.getUsername()));
        }

        User user = initializeUser(registerRequest);

        return null;
    }

    private User initializeUser(RegisterRequest registerRequest) {

        return User.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())

                .build();
    }
}
