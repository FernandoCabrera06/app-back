package com.appnotespring.service;
import com.appnotespring.entity.Note;
import com.appnotespring.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public List<Note> getNotesActive() {
        return noteRepository.findAllActive();
    }
    public List<Note> getNotesArchived() {
        return noteRepository.findAllArchived();
    }


    public Optional<Note> getNoteById(int id) {
        return noteRepository.findById(id);
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNote(int id) {
        noteRepository.deleteById(id);
    }

    public Note editNote(Note note) {
        return noteRepository.save(note);
    }



    public void archiveNote(int id) {
    Optional<Note> note = noteRepository.findById(id);
        note.get().setArchived(true);
         noteRepository.save(note.get());
    }

    public void unArchiveNote(int id) {
        Optional<Note> note = noteRepository.findById(id);
        note.get().setArchived(false);
        noteRepository.save(note.get());
    }


}
