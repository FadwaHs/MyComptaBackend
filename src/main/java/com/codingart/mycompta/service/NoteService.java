package com.codingart.mycompta.service;

import com.codingart.mycompta.model.Note;

import java.util.List;

public interface NoteService {
    Note addNote(Note note);
    Note getNote(Long id);
    List<Note> getAllNote();
    Note updateNote(Long id, Note note);
    void deleteNote(Long id);
}
