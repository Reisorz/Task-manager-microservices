package com.mls.spring.client;

import com.mls.spring.dto.TaskDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-task", url = "localhost:8082/task")
public interface TaskClient {

    @GetMapping("/find-tasks-by-userId/{userId}")
    List<TaskDTO> findTasksByUserId(@PathVariable Long userId);
}
