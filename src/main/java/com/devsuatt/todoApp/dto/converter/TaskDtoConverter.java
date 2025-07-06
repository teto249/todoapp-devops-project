package com.devsuatt.todoApp.dto.converter;

import com.devsuatt.todoApp.dto.TaskDto;
import com.devsuatt.todoApp.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoConverter {

    public TaskDto convert(Task from) {
        return new TaskDto(
                from.getId(),
                from.getTitle(),
                from.getDescription(),
                from.getCreatedDate(),
                from.getDueDate(),
                from.getStatus(),
                from.getPriority()
        );
    }
}
