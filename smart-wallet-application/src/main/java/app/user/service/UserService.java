package app.user.service;

import app.user.model.User;
import app.user.repository.UserRepository;
import app.web.dto.RegisterRequest;
import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterRequest registerRequest) {

        Optional<User> user = userRepository.findByUsername(registerRequest.getUsername());
        
        
        return null;
    }

}
