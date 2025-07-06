package com.devsuatt.todoApp.service.concrete;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.UpdateTaskRequestDto;
import com.devsuatt.todoApp.dto.converter.TaskDtoConverter;
import com.devsuatt.todoApp.exception.TaskNotFoundException;
import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.model.TaskStatus;
import com.devsuatt.todoApp.repository.TaskRepository;
import com.devsuatt.todoApp.service.abstractservice.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskManager implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskDtoConverter converter;

    public TaskManager(TaskRepository taskRepository, TaskDtoConverter converter) {
        this.taskRepository = taskRepository;
        this.converter = converter;
    }

    @Override
    public Task findTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new TaskNotFoundException("Task could not find by id: " + id));
    }

    @Override
    public TaskDto getTaskById(String id) {
        return converter.convert(findTaskById(id));
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto createTask(CreateTaskRequestDto requestDto) {
        Task task = new Task(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getDueDate(),
                requestDto.getPriority()
        );
        return converter.convert(taskRepository.save(task));
    }

    @Override
    public TaskDto updateTask(String id, UpdateTaskRequestDto requestDto) {
        Task existingTask = findTaskById(id);
        
        if (requestDto.getTitle() != null) {
            existingTask.setTitle(requestDto.getTitle());
        }
        if (requestDto.getDescription() != null) {
            existingTask.setDescription(requestDto.getDescription());
        }
        if (requestDto.getDueDate() != null) {
            existingTask.setDueDate(requestDto.getDueDate());
        }
        if (requestDto.getStatus() != null) {
            existingTask.setStatus(requestDto.getStatus());
        }
        if (requestDto.getPriority() != null) {
            existingTask.setPriority(requestDto.getPriority());
        }
        
        return converter.convert(taskRepository.save(existingTask));
    }

    @Override
    public TaskDto completeTask(String id) {
        Task task = findTaskById(id);
        task.setStatus(TaskStatus.COMPLETED);
        return converter.convert(taskRepository.save(task));
    }

    @Override
    public void deleteTask(String id) {
        Task task = findTaskById(id);
        taskRepository.deleteById(task.getId());
    }
}
