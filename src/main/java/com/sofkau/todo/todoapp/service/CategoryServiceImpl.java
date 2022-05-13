package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.CategoryDto;
import com.sofkau.todo.todoapp.dto.Mapper;
import com.sofkau.todo.todoapp.entity.Note;
import com.sofkau.todo.todoapp.repository.CategoryRepository;
import com.sofkau.todo.todoapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<CategoryDto> findAllCategories() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categoryDtos.add(mapper.fromEntityToCategoryDto(category)));
        return categoryDtos;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return mapper.fromEntityToCategoryDto(categoryRepository.save(mapper.fromCategoryDtoToEntity(categoryDto)));
    }

    @Override
    public void deleteCategory(Long id) {
        List<Note> notes = noteRepository.findByCategoryId(id);
        if(notes.size() > 0){
            notes.forEach(notesToDelete -> noteRepository.deleteById(notesToDelete.getId()));
        }
        categoryRepository.deleteById(id);
    }
}
