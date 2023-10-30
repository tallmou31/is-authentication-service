package sn.esmt.mp2isi.integration.authentificationservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.esmt.mp2isi.integration.authentificationservice.model.User;
import sn.esmt.mp2isi.integration.authentificationservice.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        // Initialisation des données des utilisateurs
        User utilisateur1 = new User("sntest1", "Esmt@1234");
        User utilisateur2 = new User("sntest2", "Esmt@1234");

        // Enregistrement des utilisateurs dans la base de données
        if (!userRepository.findTopByLoginIgnoreCase(utilisateur1.getLogin()).isPresent()) {
            userRepository.save(utilisateur1);
        }
        if (!userRepository.findTopByLoginIgnoreCase(utilisateur2.getLogin()).isPresent()) {
            userRepository.save(utilisateur2);
        }
    }
}
