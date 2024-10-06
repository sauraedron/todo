package com.sauraedron.web.core_logic;

import com.sauraedron.models.entities.Task;
import com.sauraedron.repository.TaskRepository;
import com.sauraedron.wire_models.TaskRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.UUID;

@Component
public class TaskDBDefaultImplementation implements TaskDB {

    private TaskRepository taskRepository;
    @Override
    public Task save(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTaskId(UUID.randomUUID().toString());
        task.setCreatedAt(OffsetDateTime.now());
        BeanUtils.copyProperties(taskRequest, task);
        return taskRepository.save(task);
    }

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
}
