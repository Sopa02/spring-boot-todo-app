package com.example.todoapplication.controllers;

import com.example.todoapplication.models.TodoItem;
import com.example.todoapplication.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        modelAndView.addObject("completedTasksCount", todoItemService.getAllByIsDone(true).spliterator().getExactSizeIfKnown());
        modelAndView.addObject("notCompletedTasksCount", todoItemService.getAllByIsDone(false).spliterator().getExactSizeIfKnown());
        modelAndView.addObject("overdueTasksCount", findAllOverdueItems().size());
        return modelAndView;
    }
    public List<TodoItem> findAllOverdueItems() {
        List<TodoItem> overdueItems = new ArrayList<>();
        for (TodoItem todoItem : todoItemService.getAll()) {
            if (todoItem.getIsOverdue()) {
                overdueItems.add(todoItem);
            }
        }
        return overdueItems;
    }
}
