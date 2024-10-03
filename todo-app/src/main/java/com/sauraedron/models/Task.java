package com.sauraedron.models;

import com.sauraedron.wire_models.TaskRequest;


public class Task extends TaskRequest {
    /**
     * TaskId of the task in UUID Format
     */
    String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
