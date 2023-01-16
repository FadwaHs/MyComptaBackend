package com.codingart.mycompta.service.general_infos;

import com.codingart.mycompta.model.general_infos.Note;

import java.util.List;

public interface NoteService {
    Note addNote(Note note);
    Note getNote(Long id);
    List<Note> getAllNote();
    Note updateNote(Long id, Note note);
    void deleteNote(Long id);
}
