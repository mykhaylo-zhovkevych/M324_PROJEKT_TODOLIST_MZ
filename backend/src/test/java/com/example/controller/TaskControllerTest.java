package com.example.controller;

import com.example.Task;
import com.example.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;

class TaskControllerTest {

    private TaskRepository taskRepository;
    private TaskController taskController;

    @BeforeEach
    void setUp() throws Exception {
        taskRepository = mock(TaskRepository.class);
        taskController = new TaskController();

        // Use reflection to inject the mock repository
        java.lang.reflect.Field repoField = TaskController.class.getDeclaredField("taskRepository");
        repoField.setAccessible(true);
        repoField.set(taskController, taskRepository);
    }

    @Test
    void getAllTasks_returnsTaskList() {
        Task task1 = new Task(); task1.setId(1L); task1.setTaskdescription("Test 1");
        Task task2 = new Task(); task2.setId(2L); task2.setTaskdescription("Test 2");

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));

        ResponseEntity<List<Task>> response = taskController.getAllTasks();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
        assertEquals("Test 1", response.getBody().get(0).getTaskdescription());
    }

    @Test
    void addTask_savesAndReturnsTask() {
        Task inputTask = new Task(); inputTask.setTaskdescription("New Task");
        Task savedTask = new Task(); savedTask.setId(10L); savedTask.setTaskdescription("New Task");

        when(taskRepository.save(inputTask)).thenReturn(savedTask);

        ResponseEntity<Task> response = taskController.addTask(inputTask);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(savedTask.getId(), response.getBody().getId());
        assertEquals("New Task", response.getBody().getTaskdescription());
        verify(taskRepository).save(inputTask);
    }

    @Test
    void delTask_existingId_deletesAndReturnsOk() {
        Long id = 5L;
        when(taskRepository.existsById(id)).thenReturn(true);

        ResponseEntity<Void> response = taskController.delTask(id);

        assertEquals(200, response.getStatusCodeValue());
        verify(taskRepository).deleteById(id);
    }

}