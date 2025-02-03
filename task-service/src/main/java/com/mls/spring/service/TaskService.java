package com.mls.spring.service;

import com.mls.spring.model.TaskEntity;
import com.mls.spring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity saveTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    public List<TaskEntity> listTasks() {
        return taskRepository.findAll();
    }
}
