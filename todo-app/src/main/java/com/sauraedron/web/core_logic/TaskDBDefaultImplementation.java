package com.sauraedron.web.core_logic;

import com.sauraedron.factory.TaskFactory;
import com.sauraedron.models.entities.Task;
import com.sauraedron.repository.TaskRepository;
import com.sauraedron.wire_models.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskDBDefaultImplementation implements TaskDB {
    private TaskRepository taskRepository;
    @Override
    public Task save(TaskRequest taskRequest) {
        Task task = TaskFactory.createTask(taskRequest);
        return taskRepository.save(task);
    }
    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
