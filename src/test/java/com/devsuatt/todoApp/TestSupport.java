package com.devsuatt.todoApp;

import com.devsuatt.todoApp.dto.CreateTaskRequestDto;
import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.model.TaskStatus;
import com.devsuatt.todoApp.model.Priority;

import java.time.LocalDateTime;

public class TestSupport {

    public Task generateTask(String id, String title, String description) {
        Task task = new Task();
        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setCreatedDate(LocalDateTime.now());
        task.setStatus(TaskStatus.PENDING);
        task.setPriority(Priority.MEDIUM);
        return task;
    }

    public CreateTaskRequestDto generateRequestDto() {
        return new CreateTaskRequestDto("taskTitle", "taskDescription", null, Priority.MEDIUM);
    }

}
