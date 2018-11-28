package com.amydegregorio.jvmlanguages.groovy.dto

import com.amydegregorio.jvmlanguages.groovy.util.Priorities
import com.amydegregorio.jvmlanguages.groovy.util.Statuses
import java.time.LocalDate
import javax.validation.constraints.NotNull

class TaskDto {
   Long id;
   @NotNull
   String description;
   LocalDate startDate;
   LocalDate completionDate;
   Priorities priority;
   Statuses status;
}
