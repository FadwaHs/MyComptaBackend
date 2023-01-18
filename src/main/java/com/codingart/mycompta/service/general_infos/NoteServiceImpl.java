package com.codingart.mycompta.service.general_infos;

import com.codingart.mycompta.exception.ResourceNotFoundException;
import com.codingart.mycompta.model.general_infos.Note;
import com.codingart.mycompta.repository.general_infos.NoteRepository;
import com.codingart.mycompta.service.general_infos.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final String message = "Note not found for this id :: ";


    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);

    }

    @Override
    public Note getNote(Long id) {
        return noteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
    }

    @Override
    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }

    @Override
    public Note updateNote( Long id, Note note) {
        noteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        note.setId(id);
        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        noteRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException(message+id));
        noteRepository.deleteById(id);
    }

}
