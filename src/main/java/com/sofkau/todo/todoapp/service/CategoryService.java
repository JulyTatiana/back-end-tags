package com.sofkau.todo.todoapp.service;

import com.sofkau.todo.todoapp.dto.CategoryDto;
import com.sofkau.todo.todoapp.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAllCategories();

    CategoryDto createCategory(CategoryDto categoryDto);

    void deleteCategory(Long id);
}
