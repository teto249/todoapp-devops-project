package com.devsuatt.todoApp.service;

import com.devsuatt.todoApp.TestSupport;
import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.dto.converter.TaskDtoConverter;
import com.devsuatt.todoApp.exception.TaskNotFoundException;
import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.model.TaskStatus;
import com.devsuatt.todoApp.model.Priority;
import com.devsuatt.todoApp.repository.TaskRepository;
import com.devsuatt.todoApp.service.concrete.TaskManager;
import com.devsuatt.todoApp.service.abstractservice.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.mock;

class TaskServiceTest extends TestSupport {

    private TaskRepository taskRepository;
    private TaskDtoConverter converter;

    private TaskService taskService;

    @BeforeEach
    public void setup() {
        taskRepository = mock(TaskRepository.class);
        converter = mock(TaskDtoConverter.class);

        taskService = new TaskManager(taskRepository, converter);
    }

    @Test
    public void testFindByTaskId_whenTaskIdExists_shouldReturnTask() {
        long start = System.currentTimeMillis();
        Task task = generateTask("id", "title", "description");

        Mockito.when(taskRepository.findById(task.getId()))
                .thenReturn(Optional.of(task));

        Task result = taskService.findTaskById(task.getId());

        assertEquals(result, task);
        long end = System.currentTimeMillis();
        System.out.println("Execution time (testFindByTaskId_whenTaskIdExists_shouldReturnTask): " + (end - start) + " ms");
    }

    @Test
    public void testFindByTaskId_whenTaskIdDoesNotExists_shouldThrowTaskNotFoundException() {
        long start = System.currentTimeMillis();
        Mockito.when(taskRepository.findById("id"))
                .thenReturn(Optional.empty());

        assertThrows(TaskNotFoundException.class,
                () -> taskService.findTaskById("id"));
        long end = System.currentTimeMillis();
        System.out.println("Execution time (testFindByTaskId_whenTaskIdDoesNotExists_shouldThrowTaskNotFoundException): " + (end - start) + " ms");
    }

    @Test
    public void testCreateTask_shouldCreateTask() {
        long start = System.currentTimeMillis();
        CreateTaskRequestDto requestDto = generateRequestDto();
        Task task = generateTask("","taskTitle", "taskDescription");
        TaskDto expected = new TaskDto("taskId",
                "taskTitle",
                "taskDescription",
                LocalDateTime.now(),
                null,
                TaskStatus.PENDING,
                Priority.MEDIUM);

        Mockito.when(taskRepository.save(Mockito.any(Task.class))).thenReturn(task);
        Mockito.when(converter.convert(task)).thenReturn(expected);

        TaskDto result = taskService.createTask(requestDto);

        assertNotNull(result);
        long end = System.currentTimeMillis();
        System.out.println("Execution time (testCreateTask_shouldCreateTask): " + (end - start) + " ms");
    }

}