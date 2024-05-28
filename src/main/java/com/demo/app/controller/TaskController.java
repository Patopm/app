package com.demo.app.controller;

import com.demo.app.model.Task;
import com.demo.app.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping(path = "/addTask")
    public void addNewTask(@RequestBody Task newTask){
        taskService.addNewTask(newTask);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteTask(@PathVariable(name = "id") Long id){
        taskService.deleteTask(id);
    }

    @PutMapping(path = "/{id}")
    public void updateTask(@PathVariable(name = "id") Long id, @RequestBody Task task){
        taskService.updateUsuario(id, task);
    }
}
