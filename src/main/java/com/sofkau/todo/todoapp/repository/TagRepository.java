package com.sofkau.todo.todoapp.repository;

import com.sofkau.todo.todoapp.entity.Note;
import com.sofkau.todo.todoapp.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {
    public List<Tag> findByNoteId(Long noteId);
}
