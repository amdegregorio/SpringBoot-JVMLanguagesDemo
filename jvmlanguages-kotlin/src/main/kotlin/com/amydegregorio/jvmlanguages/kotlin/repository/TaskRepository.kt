package com.amydegregorio.jvmlanguages.kotlin.repository

import org.springframework.data.jpa.repository.JpaRepository

import com.amydegregorio.jvmlanguages.kotlin.domain.Task

interface TaskRepository : JpaRepository<Task, Long> {
}