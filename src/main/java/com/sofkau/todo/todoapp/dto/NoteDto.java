package com.sofkau.todo.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class NoteDto{
    private Long id;
    private String message;
    private boolean done;
    private List<TagDto> tagList = new ArrayList<>();
    private Long categoryId;
}
