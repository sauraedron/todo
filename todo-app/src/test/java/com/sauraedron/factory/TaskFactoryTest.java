package com.sauraedron.factory;

import com.sauraedron.models.Task;
import com.sauraedron.wire_models.TaskRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class TaskFactoryTest {

    @Test
    public void testCreateTask() {
        OffsetDateTime createAt = OffsetDateTime.now();
        String testDescription = "Test Description";
        TaskRequest createTask = TaskRequest.builder().createdAt(createAt).order(BigDecimal.ONE).description(testDescription).build();
        Task task = TaskFactory.createTask(createTask);
        assertEquals(BigDecimal.ONE, task.getOrder());
        assertEquals(createAt, task.getCreatedAt());
        assertEquals(testDescription, task.getDescription());
        assertNotNull(task.getTaskId());
    }
}