package com.services;


import com.entities.Task;
import com.exceptions.NotFoundExceptions;
import com.mapp.RespList;
import com.mapp.TaskMapper;
import com.mapp.TasksCreationMapp;
import com.models.ListTasks;
import com.models.Tasks;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service 
@RequiredArgsConstructor 
public class TaskService { 
	
    private final TasksOperationsInt tasksOperationsInt; 
    private final PagedResourcesAssembler<Task> pagedResourcesAssembler; 
 
    public Tasks findById(final Long id) { 
        return tasksOperationsInt.findById(id) 
                .map(TasksCreationMapp::create) 
                .orElseThrow(() -> new NotFoundExceptions("Error", "Error")); 
    } 
 
    public ListTasks findByTask(String task) { 
        List<Task> tasks = tasksOperationsInt.findByTask(task); 
        List<Tasks> ts = tasks.stream() 
                .map(TasksCreationMapp::create) 
                .collect(Collectors.toList()); 
        return RespList.create(ts); 
    } 
 
    public ListTasks findAll(int page, int size) { 
        Pageable pageable = PageRequest.of(page, size); 
        Page<Task> pageTask = tasksOperationsInt.findAll(pageable); 
        List<Tasks> ts = pageTask.getContent().stream() 
                .map(TasksCreationMapp::create) 
                .collect(Collectors.toList()); 
        return RespList.create(ts); 
    } 
 
    public Tasks create(Tasks ts) { 
    	ts.setDateTask(LocalDate.now()); 
        Task task = tasksOperationsInt.save(TaskMapper.create(ts)); 
        return TasksCreationMapp.create(task); 
    } 
 
    public void delete(Long id) { 
    	tasksOperationsInt.findById(id).ifPresent(tasksOperationsInt::delete); 
    } 
 
    public Tasks update(Tasks ts) { 
        return tasksOperationsInt.findById(ts.getId()) 
                .map(task -> { 
                	ts.setId(task.getId()); 
                    return create(ts); 
                }) 
                .orElseThrow(() -> new NotFoundExceptions("Error", "Error")); 
    } 
} 
