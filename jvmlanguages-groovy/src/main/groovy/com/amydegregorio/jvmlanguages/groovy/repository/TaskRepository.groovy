package com.amydegregorio.jvmlanguages.groovy.repository;

import com.amydegregorio.jvmlanguages.groovy.domain.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository extends JpaRepository<Task, Long> {
   
}