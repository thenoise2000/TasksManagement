package com.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TasksOperationsInt {
	
	Task save(Task task);
	
	Page<Task> findAll(Pageable pageable);

    Optional<Task> findById(Long id);

    List<Task> findByTask(String task);        

    void delete(Task task);
}
