package com.devsuatt.todoApp.dto;

import com.devsuatt.todoApp.model.TaskStatus;
import com.devsuatt.todoApp.model.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UpdateTaskRequestDto {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private TaskStatus status;
    private Priority priority;
}
