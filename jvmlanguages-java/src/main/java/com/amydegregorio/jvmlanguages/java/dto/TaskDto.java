/**
 * 
 */
package com.amydegregorio.jvmlanguages.java.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

/**
 * @author AMD
 *
 */
public class TaskDto {
   private Long Id;
   @NotNull
   private String description;
   private LocalDate startDate;
   private LocalDate completionDate;
   private String priority;
   private String status;
   
   /**
    * Gets id.
    * @return the id
    */
   public Long getId() {
      return Id;
   }
   
   /**
    * Sets id.
    * @param id the id to set
    */
   public void setId(Long id) {
      Id = id;
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
   public String getPriority() {
      return priority;
   }
   
   /**
    * Sets priority.
    * @param priority the priority to set
    */
   public void setPriority(String priority) {
      this.priority = priority;
   }
   
   /**
    * Gets status.
    * @return the status
    */
   public String getStatus() {
      return status;
   }
   
   /**
    * Sets status.
    * @param status the status to set
    */
   public void setStatus(String status) {
      this.status = status;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "TaskDto [Id=" + Id + ", description=" + description + ", startDate=" + startDate + ", completionDate="
               + completionDate + ", priority=" + priority + ", status=" + status + "]";
   }
}
