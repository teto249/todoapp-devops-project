package com.devsuatt.todoApp.controller;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.UpdateTaskRequestDto;
import com.devsuatt.todoApp.model.TaskStatus;
import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.service.concrete.TaskManager;
import com.devsuatt.todoApp.service.abstractservice.TaskService;
import com.devsuatt.todoApp.shared.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskManager taskManager) {
        this.taskService = taskManager;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable String id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskDto>> getTasksByStatus(@PathVariable TaskStatus status) {
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }

    @PostMapping
    public ResponseEntity<?> createTask(@Valid @RequestBody CreateTaskRequestDto createTaskRequestDto) {
        if (createTaskRequestDto.getTitle() == null || createTaskRequestDto.getTitle().isEmpty()) {
            return ResponseEntity.badRequest().body("Title is required");
        }
        TaskDto createdTask = taskService.createTask(createTaskRequestDto);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable String id,
            @Valid @RequestBody UpdateTaskRequestDto requestDto) {
        return ResponseEntity.ok(taskService.updateTask(id, requestDto));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<TaskDto> completeTask(@PathVariable String id) {
        return ResponseEntity.ok(taskService.completeTask(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") String id) {
        taskService.deleteTask(id);
        GenericResponse response = new GenericResponse("Task deleted successfully");
        return ResponseEntity.ok(response);
    }
}
