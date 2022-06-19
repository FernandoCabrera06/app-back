package com.app_notes.controller;
import com.app_notes.entity.Note;
import com.app_notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class NoteController {
    @Autowired
    NoteService noteService;

    @GetMapping("/notesActive")
    public List<Note> getNotesActive() {
        return noteService.getNotesActive();
    }


    @GetMapping("/notesArchived")
    public List<Note> getNotesArchived() {
        return noteService.getNotesArchived();
    }
    @GetMapping("/noteById/{id}")
    public Optional<Note> getNoteById(@PathVariable("id") int id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/addNote")
    public Note addNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @DeleteMapping("/deleteNote/{id}")
    public void deleteNote(@PathVariable("id") int id) {
        noteService.deleteNote(id);
    }

    @DeleteMapping("/archiveNote/{id}")
    public void archiveNote(@PathVariable("id") int id) {
        noteService.archiveNote(id);
    }
    @DeleteMapping("/unArchiveNote/{id}")
    public void unArchiveNote(@PathVariable("id") int id) {
        noteService.unArchiveNote(id);
    }

    @PutMapping("/editNote")
    public Note editNote(@RequestBody Note note) {
        return noteService.editNote(note);
    }

}
