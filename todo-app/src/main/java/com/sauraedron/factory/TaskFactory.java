package com.sauraedron.factory;

import com.sauraedron.models.Task;
import com.sauraedron.wire_models.TaskRequest;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class TaskFactory {
    /**
     * Create a Fresh Task given Create Task Request
     * @param taskRequest
     * @return
     */
    public static Task createTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTaskId(UUID.randomUUID().toString());
        BeanUtils.copyProperties(taskRequest, task);
        return task;
    }
}
