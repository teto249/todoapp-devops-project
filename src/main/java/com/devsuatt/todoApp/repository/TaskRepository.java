package com.devsuatt.todoApp.repository;

import com.devsuatt.todoApp.model.Task;
import com.devsuatt.todoApp.model.TaskStatus;
import com.devsuatt.todoApp.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    
    List<Task> findByStatus(TaskStatus status);
    
    List<Task> findByPriority(Priority priority);
    
    List<Task> findByStatusAndPriority(TaskStatus status, Priority priority);
    
    List<Task> findByOrderByCreatedDateDesc();
    
    List<Task> findByOrderByDueDateAsc();
}
