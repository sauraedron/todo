package com.sauraedron.models;

import com.sauraedron.wire_models.TaskRequest;

import java.math.BigDecimal;


public class Task extends TaskRequest {
    /**
     * TaskId of the task in UUID Format
     */
    String taskId;

    BigDecimal order;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    public BigDecimal getOrder() {
        return order;
    }


    public void setOrder(BigDecimal order) {
        this.order = order;
    }
}
