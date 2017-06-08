package com.application.craftqueue.task;

import java.util.List;
import com.application.craftqueue.task.Task;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.data.repository.CrudRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.HibernateException;

@Transactional
@Repository
public class TaskRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void TaskRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Task> findAllTasks() {
        String hql = "FROM Task as tsk ORDER BY tsk.createdAt";
        return (List<Task>) entityManager.createQuery(hql).getResultList();
    }
    
    public Task findOneTaskById(String id) {
        return entityManager.find(Task.class, id);
    }
    
    public Task insertTask(Task tsk) {
        try {
            entityManager.persist(tsk);
        } catch(HibernateException e) {
            throw e;
        }
        return tsk;
    }
    
    public Task updateTask(Task tsk) {
        Task tas = findOneTaskById(tsk.getId());
        tas.setCreatedAt(tsk.getCreatedAt());
        tas.setDescription(tsk.getDescription());
        tas.setDueDate(tsk.getDueDate());
        tas.setPriority(tsk.getPriority());
        tas.setResolvedAt(tsk.getResolvedAt());
        tas.setStatus(tsk.getStatus());
        tas.setTitle(tsk.getTitle());
        tas.setUpdatedAt(tsk.getUpdatedAt());
        entityManager.flush();
        return tas;
    }

    public boolean deleteTask(String id) {
        try {
            entityManager.remove(findOneTaskById(id));
        } catch(HibernateException  e) {
            throw e;
        }
        return true;
    }
    
}
