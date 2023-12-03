package com.example.todoapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

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
    @Transient
    private boolean isOverdue;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dueDate;
    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String createdAtFormatted() {
        LocalDateTime createdAtAsDateTime = LocalDateTime.ofInstant(createdAt, ZoneId.systemDefault());
        String month = formatNumber(createdAtAsDateTime.getMonthValue());
        String day = formatNumber(createdAtAsDateTime.getDayOfMonth());
        String hour = formatNumber(createdAtAsDateTime.getHour());
        String minute = formatNumber(createdAtAsDateTime.getMinute());
        return String.format("%s.%s.%s - %s:%s",
                createdAtAsDateTime.getYear(), month, day, hour, minute);
    }
    public String updatedAtFormatted() {
        LocalDateTime updatedAtAsDateTime = LocalDateTime.ofInstant(updatedAt, ZoneId.systemDefault());
        String month = formatNumber(updatedAtAsDateTime.getMonthValue());
        String day = formatNumber(updatedAtAsDateTime.getDayOfMonth());
        String hour = formatNumber(updatedAtAsDateTime.getHour());
        String minute = formatNumber(updatedAtAsDateTime.getMinute());
        return String.format("%s.%s.%s - %s:%s",
                updatedAtAsDateTime.getYear(), month, day, hour, minute);
    }
    public String dueDateFormatted() {
        String month = formatNumber(dueDate.getMonthValue());
        String day = formatNumber(dueDate.getDayOfMonth());
        String hour = formatNumber(dueDate.getHour());
        String minute = formatNumber(dueDate.getMinute());
        return String.format("%s.%s.%s - %s:%s",
                dueDate.getYear(), month, day, hour, minute);
    }
    @Override
    public String toString(){
        return String.format("TodoItem[id=%d, description='%s', isDone='%s', createdAt='%s', updatedAt='%s']",
                id, description, isDone, createdAt, updatedAt);
    }
    private String formatNumber(int number) {
        return number < 10 ? "0" + number : String.valueOf(number);
    }
    public boolean getIsOverdue() {
        return dueDate.isBefore(LocalDateTime.now()) && !isDone;
    }
    public void setIsOverdue() {
        isOverdue = dueDate.isBefore(LocalDateTime.now()) && !isDone;
    }
}
