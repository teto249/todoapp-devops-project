package com.devsuatt.todoApp.dto;

import com.devsuatt.todoApp.model.Priority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CreateTaskRequestDto {
    @NotBlank(message = "Title cannot be blank!")
    private String title;
    
    private String description;
    
    private LocalDateTime dueDate;
    
    private Priority priority;
}
