package com.amydegregorio.jvmlanguages.kotlin.domain

import com.amydegregorio.jvmlanguages.kotlin.util.Priorities
import com.amydegregorio.jvmlanguages.kotlin.util.Statuses

import java.time.LocalDate

import javax.persistence.Entity
import javax.persistence.Column
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType


@Entity
data class Task (
	@Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   var id: Long,
   @Column(nullable = false)
   var description: String,
   @Column(nullable = true)
   var startedDate: LocalDate? = null,
   @Column(nullable = true)
   var completion: LocalDate? = null,
   @Column(nullable = true)
   var priority: Priorities? = null,
   @Column(nullable = true)
   var status: Statuses? = null
)