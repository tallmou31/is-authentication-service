package sn.esmt.mp2isi.integration.authentificationservice.service;

import sn.esmt.mp2isi.integration.authentificationservice.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> authenticate(String login, String password);
}
