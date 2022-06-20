package com.appnotespring.repository;

import com.appnotespring.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    @Query(value="SELECT * FROM note WHERE is_archived = false", nativeQuery = true)
    List<Note> findAllActive();

    @Query(value="SELECT * FROM note WHERE is_archived = true", nativeQuery = true)
    List<Note> findAllArchived();

}
