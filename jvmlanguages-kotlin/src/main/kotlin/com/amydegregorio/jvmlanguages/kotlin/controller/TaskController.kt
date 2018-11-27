package com.amydegregorio.jvmlanguages.kotlin.controller

import com.amydegregorio.jvmlanguages.kotlin.repository.TaskRepository
import com.amydegregorio.jvmlanguages.kotlin.domain.Task
import com.amydegregorio.jvmlanguages.kotlin.dto.TaskDto;
import com.amydegregorio.jvmlanguages.kotlin.util.Priorities
import com.amydegregorio.jvmlanguages.kotlin.util.Statuses

import org.modelmapper.ModelMapper

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import java.util.stream.Collectors

import javax.validation.Valid

@Controller
class TaskController(
	private val taskRepository: TaskRepository,
	private val modelMapper: ModelMapper) {
	
	@GetMapping("/")
   fun listAll(model: Model): String {
		val tasks: List<Task> = taskRepository.findAll();
		val taskDtos : List<TaskDto> = tasks.map{task -> modelMapper.map(task, TaskDto::class.java)}
		
		model.addAttribute("tasks", taskDtos)
		return "task/list";
	}
	
	@GetMapping("/task/add")
   fun addTask(taskDto: TaskDto, model: Model): String {
      model.addAttribute("action", "task/add");
      return "task/entry";
   }
	
	@PostMapping(value = arrayOf("/task/add"),  params = arrayOf("save"))
   fun saveNewTask(@Valid taskDto: TaskDto, bindingResult: BindingResult, model: Model): String {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "task/add");
         return "task/entry";
      }
      
      var task: Task = modelMapper.map(taskDto, Task::class.java);
      taskRepository.save(task);
      return "redirect:/";
   }
	
	@PostMapping(value=arrayOf("/task/add"), params = arrayOf("cancel"))
   fun cancelNewTask() = "redirect:/"
	
	@GetMapping("/task/edit")
   fun editTask(model: Model, @RequestParam("id") id: Long): String {
      model.addAttribute("action", "task/edit");
      var task : Task = taskRepository.getOne(id);
      System.out.println("Domain: " + task.toString());
      var taskDto: TaskDto = modelMapper.map(task, TaskDto::class.java)
      model.addAttribute("taskDto", taskDto);
      return "task/entry";
   }
	
	@PostMapping(value=arrayOf("/task/edit"),  params=arrayOf("save"))
   fun saveTask(@Valid taskDto: TaskDto, bindingResult: BindingResult, model: Model): String {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "task/edit");
         return "task/entry";
      }
      
      var task: Task = modelMapper.map(taskDto, Task::class.java)
      taskRepository.save(task);
      return "redirect:/";
   }
   
   @PostMapping(value=arrayOf("/task/edit"), params=arrayOf("cancel"))
   fun cancelTask() = "redirect:/"
	
	@GetMapping("/task/delete") 
   fun deleteTask(@RequestParam("id") id: Long): String{
      var task: Task = taskRepository.getOne(id);
      taskRepository.delete(task);
      return "redirect:/";
   }
	
	@ModelAttribute("priorities")
	fun getPriorities() = Priorities.values()
   
   @ModelAttribute("statuses") 
   fun getStatuses() =  Statuses.values()
}