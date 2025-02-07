package com.mls.spring.http.response;

import com.mls.spring.dto.TaskDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskByUserResponse {

    private String username;
    private String email;
    private List<TaskDTO> taskDTOList;
}
