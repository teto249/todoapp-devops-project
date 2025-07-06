package com.devsuatt.todoApp.service.abstractservice;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.UpdateTaskRequestDto;
import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.model.TaskStatus;

import java.util.List;

public interface TaskService {

    Task findTaskById(String id);

    TaskDto getTaskById(String id);

    List<TaskDto> getAllTasks();

    List<TaskDto> getTasksByStatus(TaskStatus status);

    TaskDto createTask(CreateTaskRequestDto requestDto);

    TaskDto updateTask(String id, UpdateTaskRequestDto requestDto);

    TaskDto completeTask(String id);

    void deleteTask(String id);
}
