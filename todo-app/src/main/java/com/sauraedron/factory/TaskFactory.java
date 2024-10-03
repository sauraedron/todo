package com.sauraedron.factory;

import com.sauraedron.web.core_logic.TaskOrderTracker;
import com.sauraedron.wire_models.MasterTask;
import com.sauraedron.wire_models.TaskRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;


@Service
public class TaskFactory {
    /**
     * Create a Fresh Task given Create Task Request
     * @param taskRequest
     * @return
     */
    public static MasterTask createTask(TaskRequest taskRequest) {
        MasterTask task = MasterTask.builder().
        taskid(UUID.randomUUID()).createdAt(OffsetDateTime.now()).build();
        task.order(TaskOrderTracker.next());
        BeanUtils.copyProperties(taskRequest, task);
        return task;
    }
}
