package com.sauraedron.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
public class Task {

    @Id
    private String taskId;
    @Column
    private String description;
    @Column(name = "ord")
    private Integer order;
    @Column
    private OffsetDateTime createdAt;
    @Column
    private OffsetDateTime updatedAt;
    @Column
    private OffsetDateTime completedAt;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public OffsetDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(OffsetDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
