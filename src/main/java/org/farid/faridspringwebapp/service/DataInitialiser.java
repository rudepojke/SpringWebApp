package org.farid.faridspringwebapp.service;

import jakarta.annotation.PostConstruct;
import org.farid.faridspringwebapp.model.ApplicationUser;
import org.farid.faridspringwebapp.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitialiser {
    @Autowired
    private ApplicationUserRepository repo;
    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        ApplicationUser u1 = new ApplicationUser();
        u1.setUsername("user");
        u1.setPassword(encoder.encode("password"));
        u1.setRole("ROLE_USER");
        repo.save(u1);

        ApplicationUser a1 = new ApplicationUser();
        a1.setUsername("admin");
        a1.setPassword(encoder.encode("adminpass"));
        a1.setRole("ROLE_ADMIN");
        repo.save(a1);

        ApplicationUser m1 = new ApplicationUser();
        m1.setUsername("manager");
        m1.setPassword(encoder.encode("managerpass"));
        m1.setRole("ROLE_MANAGER");
        repo.save(m1);
    }
}
