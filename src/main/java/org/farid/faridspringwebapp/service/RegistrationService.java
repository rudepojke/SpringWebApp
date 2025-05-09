package org.farid.faridspringwebapp.service;

import org.farid.faridspringwebapp.model.ApplicationUser;
import org.farid.faridspringwebapp.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private ApplicationUserRepository repo;
    @Autowired
    private PasswordEncoder encoder;

    public void register(RegistrationRequest req) {
        if (repo.findByUsername(req.getUsername()).isPresent()) {
            throw new RuntimeException("Användarnamn upptaget");
        }
        ApplicationUser u = new ApplicationUser();
        u.setUsername(req.getUsername());
        u.setPassword(encoder.encode(req.getPassword()));
        u.setRole("ROLE_USER");
        repo.save(u);
    }
}
