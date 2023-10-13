package com.mapp;

import com.entities.Task;
import com.models.Tasks;

import java.util.Optional;

import org.modelmapper.ModelMapper;

public class TaskMapper {

	public static Task create(Tasks tasks) { 
	    return Optional.ofNullable(tasks) 
	            .map(t -> new ModelMapper().map(t, Task.class)) 
	            .orElse(null); 
	} 

}
