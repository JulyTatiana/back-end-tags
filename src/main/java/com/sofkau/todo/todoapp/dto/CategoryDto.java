package com.sofkau.todo.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDto{
    private Long id;
    private String title;
    private List<NoteDto> notes = new ArrayList<>();
}
