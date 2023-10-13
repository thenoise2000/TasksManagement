package com.controller;


import com.exceptions.ControllerErrorResp;
import com.models.ListTasks;
import com.models.Tasks;
import com.services.TaskService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@Slf4j
@RestController
@RequestMapping("/api/task")
@RequiredArgsConstructor
public class MainController extends ControllerErrorResp {
       
    private final TaskService taskService;      
    
    @GetMapping("/{id}") 
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {         
        return ResponseEntity.ok(taskService.findById(id)); 
    }     
    
    @GetMapping() 
    public ResponseEntity<?> findAll( 
            @RequestParam(value = "page", required = false, defaultValue = "0") final int page, 
            @RequestParam(value = "page-size", required = false, defaultValue = "10") final int size) { 
        return ResponseEntity.ok(taskService.findAll(page, size)); 
    } 
     
    @GetMapping("/search") 
    public ResponseEntity<?> search(@RequestParam("task") final String task) { 
        return ResponseEntity.ok(taskService.findByTask(task)); 
    }      
    
    @PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {  
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})  
    public ResponseEntity<Tasks> update(@RequestBody Tasks ts) {  
    return ResponseEntity.ok(taskService.update(ts));  
}
     
    @PostMapping 
    public ResponseEntity<Tasks> create(@RequestBody Tasks ts) {  
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(ts));  
    }
     
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) { 
        taskService.delete(id); 
        return ResponseEntity.ok().build(); 
    } 
}
