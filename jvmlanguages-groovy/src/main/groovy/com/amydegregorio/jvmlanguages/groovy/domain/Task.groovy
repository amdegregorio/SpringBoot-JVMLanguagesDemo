package com.amydegregorio.jvmlanguages.groovy.domain

import com.amydegregorio.jvmlanguages.groovy.util.Priorities
import com.amydegregorio.jvmlanguages.groovy.util.Statuses
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Task {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   Long id;
   String description;
   LocalDate startDate;
   LocalDate completionDate;
   Priorities priority;
   Statuses status;
}
