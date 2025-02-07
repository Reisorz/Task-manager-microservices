package com.mls.spring.repository;

import com.mls.spring.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    public List<TaskEntity> findByUserId(Long userId);
}
