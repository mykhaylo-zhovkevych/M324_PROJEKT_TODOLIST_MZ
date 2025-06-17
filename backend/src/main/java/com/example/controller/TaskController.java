package com.example.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task;
import com.example.repository.TaskRepository;
 
 
@RestController
@RequestMapping("/task")
public class TaskController {
 
  @Autowired
  private TaskRepository taskRepository;
 
  @CrossOrigin
  @GetMapping
  public ResponseEntity<List<Task>> getAllTasks() {
    return ResponseEntity.ok(taskRepository.findAll());
  }
 
  @PostMapping
  @CrossOrigin
  public ResponseEntity<Task> addTask(@RequestBody Task task) {
      Task savedTask = taskRepository.save(task);
      return ResponseEntity.ok(savedTask);
  }
  
 
  @CrossOrigin
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delTask(@PathVariable Long id) {
    if (taskRepository.existsById(id)) {
      taskRepository.deleteById(id);
      return ResponseEntity.ok().build();
    } 
    return ResponseEntity.notFound().build();
  }
}