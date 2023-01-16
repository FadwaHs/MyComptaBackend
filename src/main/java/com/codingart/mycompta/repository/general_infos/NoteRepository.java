package com.codingart.mycompta.repository.general_infos;

import com.codingart.mycompta.model.general_infos.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}