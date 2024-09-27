package org.example.notesappbackend.repository;

import org.example.notesappbackend.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NoteRepository extends JpaRepository<Note,Long>{
}
