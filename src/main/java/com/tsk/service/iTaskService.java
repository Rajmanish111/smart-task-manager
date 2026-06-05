package com.tsk.service;

import java.util.List;

import com.tsk.entity.Task;
import com.tsk.entityDTO.TaskDTO;

public interface iTaskService {

    Task createTask(TaskDTO taskdto);

    List<Task> getAllTasks();

    Task getById(Long id);

    Task updateTask(Long id, TaskDTO taskdto);

    void deleteTask(Long id);
}