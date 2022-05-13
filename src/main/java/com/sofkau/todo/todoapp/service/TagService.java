package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.NoteDto;
import com.sofkau.todo.todoapp.dto.TagDto;
import com.sofkau.todo.todoapp.entity.Note;

public interface TagService {

    Note createTag(TagDto tagDto);
    void deleteTag(Long id);

}
