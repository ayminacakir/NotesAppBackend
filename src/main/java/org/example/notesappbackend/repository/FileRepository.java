package org.example.notesappbackend.repository;

import org.example.notesappbackend.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FileRepository extends JpaRepository<File,Long> {
}
