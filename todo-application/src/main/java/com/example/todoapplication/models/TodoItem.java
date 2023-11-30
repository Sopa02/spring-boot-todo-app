package com.example.todoapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "todo_items")
public class TodoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private boolean isDone;
    private Instant createdAt;
    private Instant updatedAt;

    @Override
    public String toString(){
        return String.format("TodoItem[id=%d, description='%s', isDone='%s', createdAt='%s', updatedAt='%s']",
                id, description, isDone, createdAt, updatedAt);
    }
}
