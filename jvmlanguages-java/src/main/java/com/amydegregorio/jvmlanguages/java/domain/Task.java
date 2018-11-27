/**
 * 
 */
package com.amydegregorio.jvmlanguages.java.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.amydegregorio.jvmlanguages.java.util.Priorities;
import com.amydegregorio.jvmlanguages.java.util.Statuses;

/**
 * @author AMD
 *
 */
@Entity
public class Task {
   
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   private String description;
   private LocalDate startDate;
   private LocalDate completionDate;
   private Priorities priority;
   private Statuses status;
   
   /**
    * Gets id.
    * @return the id
    */
   public Long getId() {
      return id;
   }
   
   /**
    * Sets id.
    * @param id the id to set
    */
   public void setId(Long id) {
      this.id = id;
   }
   
   /**
    * Gets description.
    * @return the description
    */
   public String getDescription() {
      return description;
   }
   
   /**
    * Sets description.
    * @param description the description to set
    */
   public void setDescription(String description) {
      this.description = description;
   }
   
   /**
    * Gets startDate.
    * @return the startDate
    */
   public LocalDate getStartDate() {
      return startDate;
   }
   
   /**
    * Sets startDate.
    * @param startDate the startDate to set
    */
   public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
   }
   
   /**
    * Gets completionDate.
    * @return the completionDate
    */
   public LocalDate getCompletionDate() {
      return completionDate;
   }
   
   /**
    * Sets completionDate.
    * @param completionDate the completionDate to set
    */
   public void setCompletionDate(LocalDate completionDate) {
      this.completionDate = completionDate;
   }
   
   /**
    * Gets priority.
    * @return the priority
    */
   public Priorities getPriority() {
      return priority;
   }
   
   /**
    * Sets priority.
    * @param priority the priority to set
    */
   public void setPriority(Priorities priority) {
      this.priority = priority;
   }
   
   /**
    * Gets status.
    * @return the status
    */
   public Statuses getStatus() {
      return status;
   }
   
   /**
    * Sets status.
    * @param status the status to set
    */
   public void setStatus(Statuses status) {
      this.status = status;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "Task [id=" + id + ", description=" + description + ", startDate=" + startDate + ", completionDate="
               + completionDate + ", priority=" + priority + ", status=" + status + "]";
   }

}
