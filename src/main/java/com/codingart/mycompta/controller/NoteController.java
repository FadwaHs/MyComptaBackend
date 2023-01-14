package com.codingart.mycompta.controller;

import com.codingart.mycompta.model.Note;
import com.codingart.mycompta.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        return new ResponseEntity<>(noteService.getNote(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNote(){
        return new ResponseEntity<>(noteService.getAllNote(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody Note note){
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(id,note), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
