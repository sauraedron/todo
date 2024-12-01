package com.sauraedron.factory;

import com.sauraedron.models.entities.Task;
import com.sauraedron.web.core_logic.TaskOrderTracker;
import com.sauraedron.wire_models.TaskRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;


public class TaskFactory {
    /**
     * Create a Fresh Task given Create Task Request
     * @param taskRequest
     * @return
     */
    public static Task createTask(TaskRequest taskRequest) {
        Task task1 = new Task();

        BeanUtils.copyProperties(taskRequest, task1);
        task1.setTaskId(UUID.randomUUID().toString());
        task1.setOrder(TaskOrderTracker.next().intValue());
        task1.setCreatedAt(OffsetDateTime.now());
        return task1;
    }
}
