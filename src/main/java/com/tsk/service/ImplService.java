package com.tsk.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tsk.entity.Task;
import com.tsk.entityDTO.TaskDTO;
import com.tsk.exception.ResourceNotFoundException;
import com.tsk.repository.iRepo;

@Service
public class ImplService implements iTaskService {

    private static final Logger logger = LoggerFactory.getLogger(ImplService.class);

    private final iRepo repo;

    public ImplService(iRepo repo) {
        this.repo = repo;
    }

    // ✅ CREATE
    @Override
    public Task createTask(TaskDTO taskdto) {
        logger.info("Creating task: {}", taskdto.getTitle());

        Task task = new Task();
        task.setTitle(taskdto.getTitle());
        task.setDescription(taskdto.getDescription());
        task.setCompleted(false);

        return repo.save(task);
    }

    // ✅ GET ALL
    @Override
    public List<Task> getAllTasks() {
        logger.info("Fetching all tasks");
        return repo.findAll();
    }

    // ✅ GET BY ID
    @Override
    public Task getById(Long id) {
        logger.info("Fetching task with id: {}", id);

        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    // ✅ UPDATE (FIXED: using DTO)
    @Override
    public Task updateTask(Long id, TaskDTO taskdto) {
        logger.info("Updating task with id: {}", id);

        Task existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        existing.setTitle(taskdto.getTitle());
        existing.setDescription(taskdto.getDescription());

        return repo.save(existing);
    }

    // ✅ DELETE (FIXED: check before delete)
    @Override
    public void deleteTask(Long id) {
        logger.info("Deleting task with id: {}", id);

        Task existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        repo.delete(existing);
    }
}