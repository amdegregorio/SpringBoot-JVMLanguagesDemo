/**
 * 
 */
package com.amydegregorio.jvmlanguages.groovy.controller

import com.amydegregorio.jvmlanguages.groovy.domain.Task
import com.amydegregorio.jvmlanguages.groovy.dto.TaskDto
import com.amydegregorio.jvmlanguages.groovy.repository.TaskRepository
import com.amydegregorio.jvmlanguages.groovy.util.Priorities
import com.amydegregorio.jvmlanguages.groovy.util.Statuses
import java.util.stream.Collectors

import javax.validation.Valid

import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
class TaskController {
   @Autowired
   TaskRepository taskRepository;
   @Autowired
   ModelMapper modelMapper;
   
   @RequestMapping("/")
   String listAll(Model model) {
      List<Task> tasks = taskRepository.findAll();
      
      List<TaskDto> taskDtos = tasks.stream().map{task -> modelMapper.map(task, TaskDto.class)}.collect(Collectors.toList());
      model.addAttribute("tasks", taskDtos);
      return "task/list";
   }
   
   @RequestMapping(value="/task/add", method=RequestMethod.GET)
   String addTask(TaskDto taskDto, Model model) {
      model.addAttribute("action", "task/add");
      return "task/entry";
   }
   
   @RequestMapping(value="/task/add",  params=("save"), method=RequestMethod.POST)
   String saveNewTask(@Valid TaskDto taskDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "task/add");
         return "task/entry";
      }
      
      Task task = modelMapper.map(taskDto, Task.class);
      taskRepository.save(task);
      return "redirect:/";
   }
   
   @RequestMapping(value="/task/add", params=("cancel"), method=RequestMethod.POST)
   String cancelNewTask() {
      return "redirect:/";
   }
   
   @RequestMapping(value="/task/edit", method=RequestMethod.GET)
   String editTask(TaskDto taskDto, Model model, @RequestParam("id") Long id) {
      model.addAttribute("action", "task/edit");
      Task task = taskRepository.getOne(id);
      System.out.println("Domain: " + task.toString());
      taskDto = modelMapper.map(task, TaskDto.class);
      model.addAttribute("taskDto", taskDto);
      return "task/entry";
   }
   
   @RequestMapping(value="/task/edit",  params=("save"), method=RequestMethod.POST)
   String saveTask(@Valid TaskDto taskDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "task/edit");
         return "task/entry";
      }
      
      Task task = modelMapper.map(taskDto, Task.class);
      taskRepository.save(task);
      return "redirect:/";
   }
   
   @RequestMapping(value="/task/edit", params=("cancel"), method=RequestMethod.POST)
   public String cancelTask() {
      return "redirect:/";
   }
   
   @RequestMapping(value="/task/delete", method=RequestMethod.GET)
   String deleteTask(@RequestParam("id") Long id){
      Task task = taskRepository.getOne(id);
      taskRepository.delete(task);
      return "redirect:/";
   }
   
   @ModelAttribute("priorities")
   Priorities[] getPriorities() {
      return Priorities.values();
   }
   
   @ModelAttribute("statuses")
   Statuses[] getStatuses() {
      return Statuses.values();
   }
}
