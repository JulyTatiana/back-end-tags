package com.sofkau.todo.todoapp.repository;

import com.sofkau.todo.todoapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    public List<Note> findByCategoryId(Long categoryId);
}
