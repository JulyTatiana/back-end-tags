package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.CategoryDto;
import com.sofkau.todo.todoapp.dto.Mapper;
import com.sofkau.todo.todoapp.dto.NoteDto;
import com.sofkau.todo.todoapp.entity.Note;
import com.sofkau.todo.todoapp.entity.Tag;
import com.sofkau.todo.todoapp.repository.NoteRepository;
import com.sofkau.todo.todoapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private Mapper mapper;

    public List<NoteDto> findAllNotes() {
        List<NoteDto> noteDtos = new ArrayList<>();
        noteRepository.findAll().forEach(note -> noteDtos.add(mapper.fromEntityToNoteDto(note)));
        return noteDtos;
    }

    @Override
    public NoteDto createNote(NoteDto noteDto) {
        return mapper.fromEntityToNoteDto(noteRepository.save(mapper.fromNoteDtoToEntity(noteDto)));
    }

    @Override
    public NoteDto updateNote(NoteDto noteDto) {
        return mapper.fromEntityToNoteDto(noteRepository.save(mapper.fromNoteDtoToEntity(noteDto)));
    }

    @Override
    public void deleteNote(Long id) {

        List<Tag> tags = tagRepository.findByNoteId(id);
        if(tags.size() > 0){
            tags.forEach(tagsToDelete -> tagRepository.deleteById(tagsToDelete.getId()));
        }
        noteRepository.deleteById(id);
    }
}
