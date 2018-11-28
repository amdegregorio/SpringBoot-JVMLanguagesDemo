package com.amydegregorio.jvmlanguages.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amydegregorio.jvmlanguages.java.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
      
}
