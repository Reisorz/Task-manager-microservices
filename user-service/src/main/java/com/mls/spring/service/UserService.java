package com.mls.spring.service;

import com.mls.spring.client.TaskClient;
import com.mls.spring.dto.TaskDTO;
import com.mls.spring.http.response.TaskByUserResponse;
import com.mls.spring.model.UserEntity;
import com.mls.spring.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskClient taskClient;

    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> listUsers(){
        return userRepository.findAll();
    }

    public TaskByUserResponse taskByUserId(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        List<TaskDTO> tasks = taskClient.findTasksByUserId(userId);

        return TaskByUserResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .taskDTOList(tasks)
                .build();
    }
}
