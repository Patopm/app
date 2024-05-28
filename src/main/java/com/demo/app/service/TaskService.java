package com.demo.app.service;

import com.demo.app.model.Task;
import com.demo.app.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }


    public void addNewTask(Task newTask) {
        taskRepository.save(newTask);
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalStateException("el id" + id + "no existe");
        }
        taskRepository.deleteById(id);
    }

    @Transactional
    public void updateUsuario(Long id, Task updateTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("no se encontro el usuario"));
        if (updateTask.getTitle() != null && updateTask.getTitle().length() > 0 && Objects.equals(task.getTitle(), updateTask.getTitle())){
            task.setTitle(updateTask.getTitle());
        }
        if (updateTask.getTitle() != null && updateTask.getTitle().length() > 0 && Objects.equals(task.getTitle(), updateTask.getTitle())){
            task.setDescription(updateTask.getDescription());
        }
    }
}
