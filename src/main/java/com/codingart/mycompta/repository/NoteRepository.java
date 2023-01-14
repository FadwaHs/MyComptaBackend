package com.codingart.mycompta.repository;

import com.codingart.mycompta.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}