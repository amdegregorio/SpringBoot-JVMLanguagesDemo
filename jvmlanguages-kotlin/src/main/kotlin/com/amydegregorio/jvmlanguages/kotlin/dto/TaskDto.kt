package com.amydegregorio.jvmlanguages.kotlin.dto

import com.amydegregorio.jvmlanguages.kotlin.util.Priorities
import com.amydegregorio.jvmlanguages.kotlin.util.Statuses

import javax.validation.constraints.NotNull

import java.time.LocalDate

data class TaskDto (
   var id : Long = 0,
   @NotNull
   var description : String = "",
   var startDate : LocalDate? = null,
   var completionDate : LocalDate? = null,
   var priority : Priorities? = null,
   var status : Statuses? = null
)
