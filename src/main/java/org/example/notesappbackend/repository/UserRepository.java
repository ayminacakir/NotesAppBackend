package org.example.notesappbackend.repository;

import org.example.notesappbackend.model.File;
import org.example.notesappbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByEmail(String email);

    boolean existsByEmail(String email);
    Optional<User>findByUsername(String username);
    boolean existsByUsername(String username);
}
