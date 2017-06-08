package com.application.craftqueue.cronScheduler;

import java.util.Date;
import java.text.SimpleDateFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.application.craftqueue.task.Task;
import com.application.craftqueue.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class TaskScheduler {
    
    private TaskService taskService;

    @Autowired
    public TaskScheduler(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @Scheduled(cron = "*/15 * * * * *")
    public void scheduleTask() {
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000*60*60*24));
        
        Task tsk = new Task(today, today, tomorrow, null, "title", "desc", 1, "to do");
        taskService.insertTask(tsk);
    }
    
    
    
}
