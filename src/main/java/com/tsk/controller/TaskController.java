package com.tsk.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsk.entity.Task;
import com.tsk.entityDTO.TaskDTO;
import com.tsk.service.ImplService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {
 private final ImplService service;
 
 public TaskController( ImplService service) {
	  this.service= service;
 }
 
 @PostMapping("/create")
 public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDTO taskdto) {
	  Task savedTask = service.createTask(taskdto); // need to change in dto service
	 
     return new ResponseEntity <> ( savedTask , HttpStatus.CREATED);
 }
 
 @GetMapping("/getall")
 public List<Task> getTasks() {
     return service.getAllTasks();
 }
 @GetMapping("/getbyid/{id}")
 public Task getById( @PathVariable Long id) {
	 
	return service.getById(id);
	 
 }
 
 @DeleteMapping("deletebyid/{id}")
 public String deleteById(@PathVariable Long id) {
	 service.deleteTask(id);
	return "Task deleted";
 }
 @PutMapping("updatebyid/{id}")
 public Task UpdateById(@PathVariable Long id, @RequestBody Task task) {
	 return service.updateTask(id, task);
 }
	
}
