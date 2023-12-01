package com.example.todoapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

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
    private LocalDateTime dueDate;
    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String createdAtFormatted() {
        LocalDateTime createdAtAsDateTime = LocalDateTime.ofInstant(createdAt, ZoneId.systemDefault());
        return String.format("%s.%s.%s - %s:%s",
                createdAtAsDateTime.getYear(), createdAtAsDateTime.getMonthValue(), createdAtAsDateTime.getDayOfMonth(),
                createdAtAsDateTime.getHour(), createdAtAsDateTime.getMinute());
    }
    public String updatedAtFormatted() {
        LocalDateTime updatedAtAsDateTime = LocalDateTime.ofInstant(updatedAt, ZoneId.systemDefault());
        return String.format("%s.%s.%s - %s:%s",
                updatedAtAsDateTime.getYear(), updatedAtAsDateTime.getMonthValue(), updatedAtAsDateTime.getDayOfMonth(),
                updatedAtAsDateTime.getHour(), updatedAtAsDateTime.getMinute());
    }
    public String dueDateFormatted() {
        return String.format("%s.%s.%s - %s:%s",
                dueDate.getYear(), dueDate.getMonthValue(), dueDate.getDayOfMonth(), dueDate.getHour(), dueDate.getMinute());
    }
    @Override
    public String toString(){
        return String.format("TodoItem[id=%d, description='%s', isDone='%s', createdAt='%s', updatedAt='%s']",
                id, description, isDone, createdAt, updatedAt);
    }
}
