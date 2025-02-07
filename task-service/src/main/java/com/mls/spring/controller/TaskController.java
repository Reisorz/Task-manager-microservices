package com.mls.spring.controller;

import com.mls.spring.model.TaskEntity;
import com.mls.spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save-task")
    public ResponseEntity<TaskEntity> saveTask(@RequestBody TaskEntity task) {
        TaskEntity taskSaved = taskService.saveTask(task);
        return ResponseEntity.ok(taskSaved);
    }

    @GetMapping("/list-tasks")
    public List<TaskEntity> listTasks(){
        return taskService.listTasks();
    }

    @GetMapping("/find-tasks-by-userId/{userId}")
    public ResponseEntity<List<TaskEntity>> findTasksByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.findByUserId(userId));
    }
}
