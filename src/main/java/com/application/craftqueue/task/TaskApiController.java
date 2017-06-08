package com.application.craftqueue.task;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.application.craftqueue.Result;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import com.application.craftqueue.task.Task;

@RestController
@RequestMapping("v1")
public class TaskApiController {
    
    private TaskService taskService;
    
    @Autowired
    public void TaskApiController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @GetMapping("tasks")
    public ResponseEntity<List<Task>> getEveryTask() {
        List<Task> list = taskService.findAllTasks();
        return new ResponseEntity<List<Task>>(list, HttpStatus.OK);
    }
    
    @GetMapping("task/{id}")
    public ResponseEntity<Task> getGivenTask(@PathVariable String id) {
        Task task = taskService.findOneTaskById(id);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
    
    @PostMapping("task")
    public ResponseEntity<Task> createTask(@RequestBody Task tsk) {
        Task task = taskService.insertTask(tsk);
        return new ResponseEntity<Task>(task, HttpStatus.CREATED);
    }
    
    @PostMapping("task/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task tsk) {
        Task task = taskService.updateTask(tsk);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
    
    @DeleteMapping("task/{id}")
    public ResponseEntity<Result> deleteTask(@PathVariable String id) {
        boolean flag = taskService.deleteTask(id);
            Result result = new Result();
        if(flag) {
            result.positive();
            return new ResponseEntity<Result>(result, HttpStatus.NO_CONTENT);
        } else {
            result.negative();
            return new ResponseEntity<Result>(result, HttpStatus.NO_CONTENT);
        }
        
    }
}
