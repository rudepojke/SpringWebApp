package org.farid.faridspringwebapp.repository;

import org.farid.faridspringwebapp.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository för ApplicationUser med sök på användarnamn.
 */
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);
}
