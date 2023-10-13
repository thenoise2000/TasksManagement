package com.services;


import com.entities.Task;
import com.exceptions.MessageException;
import com.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Slf4j 
@Component 
@RequiredArgsConstructor 
public class TasksOperationsIntImpl implements TasksOperationsInt { 
	
	private final TaskRepository taskRepository; 
	
    private static final String ERROR_GET_ALL = "Error encountered while attempting to retrieve all tasks from the database"; 
    private static final String ERROR_ID_NOT_FOUND = "Error encountered while attempting to retrieve task by ID from the database"; 
    private static final String SAVE_ERROR = "Error encountered while attempting to save task to the database"; 
    private static final String DELETE_ERROR = "Error encountered while attempting to delete task from the database"; 
    
 
    @Override 
    public Optional<Task> findById(Long id) { 
        return tryCatch(() -> {             
            return taskRepository.findById(id); 
        }, ERROR_ID_NOT_FOUND); 
    } 
 
    @Override 
    public List<Task> findByTask(String task) { 
        return tryCatch(() -> {             
            return taskRepository.findByTaskContainingIgnoreCase(task); 
        }, ERROR_ID_NOT_FOUND); 
    } 
 
    @Override 
    public Page<Task> findAll(Pageable pageable) { 
        return tryCatch(() -> {              
            return taskRepository.findAll(pageable); 
        }, ERROR_GET_ALL); 
    } 
 
    @Override 
    public Task save(Task task) { 
        return tryCatch(() -> {            
            return taskRepository.save(task); 
        }, SAVE_ERROR); 
    } 
 
    @Override 
    public void delete(Task task) { 
        tryCatch(() -> {             
            taskRepository.delete(task); 
            return null; 
        }, DELETE_ERROR); 
    } 
 
    private <T> T tryCatch(Supplier<T> supplier, String errorMessage) { 
        try { 
            return supplier.get(); 
        } catch (Exception e) { 
            log.error(errorMessage, e); 
            throw new MessageException(errorMessage, e); 
        } 
    } 
} 