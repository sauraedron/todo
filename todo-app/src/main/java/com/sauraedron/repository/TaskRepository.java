package com.sauraedron.repository;

import com.sauraedron.models.entities.Task;
import org.springframework.data.repository.CrudRepository;



public interface TaskRepository extends CrudRepository<Task, String> {
}
