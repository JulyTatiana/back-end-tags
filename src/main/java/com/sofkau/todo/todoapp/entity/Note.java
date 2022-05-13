package com.sofkau.todo.todoapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Note")
@Table(name= "note")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private boolean done;

    private Long categoryId;

    @OneToMany(mappedBy = "noteId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Tag> tagList = new ArrayList<>();

    public Note addTag(Tag tag) {
        this.tagList.add(tag);
        return this;
    }
}
