package sn.esmt.mp2isi.integration.authentificationservice.service;

import org.springframework.stereotype.Service;
import sn.esmt.mp2isi.integration.authentificationservice.model.User;
import sn.esmt.mp2isi.integration.authentificationservice.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> authenticate(String login, String password) {
        return userRepository.findTopByLoginIgnoreCaseAndPassword(login, password);
    }
}
