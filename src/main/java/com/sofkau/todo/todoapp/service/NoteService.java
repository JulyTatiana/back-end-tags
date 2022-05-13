package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.NoteDto;

import java.util.List;

public interface NoteService {

    List<NoteDto> findAllNotes();

    NoteDto createNote(NoteDto noteDto);

    NoteDto updateNote(NoteDto noteDto);

    void deleteNote(Long id);
}
