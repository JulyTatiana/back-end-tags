package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.Mapper;
import com.sofkau.todo.todoapp.dto.NoteDto;
import com.sofkau.todo.todoapp.dto.TagDto;
import com.sofkau.todo.todoapp.entity.Note;
import com.sofkau.todo.todoapp.repository.NoteRepository;
import com.sofkau.todo.todoapp.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public Note createTag(TagDto tagDto) {
        Note note = noteRepository.findById(tagDto.getNoteId()).get();
        note.addTag(mapper.fromTagDtoToEntity(tagDto));
        return noteRepository.save(note);
//        return mapper.fromEntityToTagDto(tagRepository.save(mapper.fromTagDtoToEntity(tagDto)));
    }

    @Override
    public void deleteTag(Long id) {

        tagRepository.deleteById(id);
    }
}
