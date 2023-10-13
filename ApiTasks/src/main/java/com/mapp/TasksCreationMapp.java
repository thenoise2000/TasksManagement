package com.mapp;

import com.entities.Task;
import com.models.Tasks;

import org.modelmapper.ModelMapper;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TasksCreationMapp {

	public static Tasks create(final Task task) {
	    return ObjectUtils.isEmpty(task) ? Tasks.builder().build() : new ModelMapper().map(task, Tasks.class);
	}

	public static List<Tasks> create(final List<Task> tasks) {
	    return tasks.stream()
	            .map(t -> new ModelMapper().map(t, Tasks.class))
	            .collect(Collectors.toList());
	}
    
    
}
