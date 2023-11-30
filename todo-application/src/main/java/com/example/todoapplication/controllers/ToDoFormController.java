package com.example.todoapplication.controllers;

import com.example.todoapplication.models.TodoItem;
import com.example.todoapplication.services.TodoItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoFormController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreatedForm(TodoItem todoItem){
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult bindingResult, Model model ){
        if(!todoItem.getDescription().trim().isEmpty()){
            TodoItem item = new TodoItem();
            item.setDescription(todoItem.getDescription());
            item.setDone(false);
            todoItemService.create(item);
        }
        return "redirect:/create-todo";
    }
}