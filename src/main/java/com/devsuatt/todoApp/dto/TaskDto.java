package com.devsuatt.todoApp.dto;

import com.devsuatt.todoApp.model.TaskStatus;
import com.devsuatt.todoApp.model.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TaskDto {
    private String id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;
    private TaskStatus status;
    private Priority priority;
}
