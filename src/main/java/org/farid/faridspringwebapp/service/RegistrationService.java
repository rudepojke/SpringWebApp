package org.farid.faridspringwebapp.service;

import org.farid.faridspringwebapp.model.ApplicationUser;
import org.farid.faridspringwebapp.repository.ApplicationUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {

    private final ApplicationUserRepository repo;
    private final PasswordEncoder encoder;

    //  Konstruktor-injektion – Spring injicerar automatiskt dessa beroenden
    public RegistrationService(ApplicationUserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public void register(RegistrationRequest req) {
        if (repo.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Användarnamn upptaget");
        }

        ApplicationUser user = new ApplicationUser();
        user.setUsername(req.getUsername());
        user.setPassword(encoder.encode(req.getPassword())); // hashar lösenordet
        user.setRole("ROLE_USER");

        repo.save(user);
    }
}
