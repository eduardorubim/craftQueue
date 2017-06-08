package com.application.craftqueue.task;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.application.craftqueue.task.Task;
import com.application.craftqueue.task.TaskRepository;

@Service
public class TaskService {
    
    private TaskRepository taskRepository;
    
    @Autowired
    public void TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> findAllTasks() {
        return taskRepository.findAllTasks();
    }
    
    public Task findOneTaskById(String id) {
        Task tsk = taskRepository.findOneTaskById(id);
        return tsk;
    }
    
    public Task insertTask(Task tsk) {
        return taskRepository.insertTask(tsk);
    }
    
    public Task updateTask(Task tsk) {
        return taskRepository.updateTask(tsk);
    }
    
    public boolean deleteTask(String id) {
        return taskRepository.deleteTask(id);
    }
    
    
}
