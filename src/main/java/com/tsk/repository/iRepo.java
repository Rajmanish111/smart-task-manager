package com.tsk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsk.entity.Task;

@Repository
public interface iRepo extends JpaRepository<Task, Long> {

}
