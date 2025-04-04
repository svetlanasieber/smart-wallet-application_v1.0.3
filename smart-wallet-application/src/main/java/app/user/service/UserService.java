package app.user.service;

import app.user.model.User;
import app.user.repository.UserRepository;
import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(Registration registration) {



        return null;
    }

}
