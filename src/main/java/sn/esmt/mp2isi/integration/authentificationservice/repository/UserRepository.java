package sn.esmt.mp2isi.integration.authentificationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.esmt.mp2isi.integration.authentificationservice.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findTopByLoginIgnoreCaseAndPassword(String login, String password);
    Optional<User> findTopByLoginIgnoreCase(String login);

}
