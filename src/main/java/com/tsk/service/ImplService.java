package com.tsk.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tsk.entity.Task;
import com.tsk.entityDTO.TaskDTO;
import com.tsk.repository.iRepo;

@Service
public class ImplService implements iTaskService {

	private final iRepo repo;

	public ImplService(iRepo repo) {
		this.repo = repo;
	}

	@Override
	public Task createTask(TaskDTO taskdto) {
		Task task = new Task();
		task.setTitle(taskdto.getTitle());
		task.setDescription(taskdto.getDescription());
		task.setCompleted(false);

		return repo.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return repo.findAll();
	}

	@Override
	public Task getById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("task not found"));
	}

	@Override
	public Task updateTask(Long id, Task task) {
		Task existing = repo.findById(id).orElseThrow(() -> new RuntimeException("user Not found"));

		existing.setTitle(task.getTitle());
		existing.setDescription(task.getDescription());
		existing.setCompleted(task.isCompleted());// is complete?

		return repo.save(existing);
	}

	@Override
	public void deleteTask(Long id) {

		repo.deleteById(id);
	}

}
