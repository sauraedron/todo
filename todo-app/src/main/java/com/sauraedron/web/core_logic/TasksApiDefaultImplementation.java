package com.sauraedron.web.core_logic;

import com.sauraedron.TasksApi;
import com.sauraedron.factory.TaskFactory;
import com.sauraedron.wire_models.MasterTask;
import com.sauraedron.wire_models.TaskRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class TasksApiDefaultImplementation implements TasksApi {

    Map<UUID, MasterTask> taskMap = new ConcurrentHashMap<>();

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return TasksApi.super.getRequest();
    }

    @Override
    public ResponseEntity<TaskRequest> getTaskById(String taskId) {
        return TasksApi.super.getTaskById(taskId);
    }

    @Override
    public ResponseEntity<List<MasterTask>> getTasks() {
        return new ResponseEntity<>(new ArrayList<>(this.taskMap.values()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MasterTask> taskRequest(TaskRequest taskRequest) {
        MasterTask task = TaskFactory.createTask(taskRequest);
        task.setCreatedAt(OffsetDateTime.now());
        this.taskMap.put(task.getTaskid(), task);
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MasterTask> createTask(TaskRequest taskRequest) {
        MasterTask task = TaskFactory.createTask(taskRequest);
        task.setCreatedAt(OffsetDateTime.now());
        this.taskMap.put(task.getTaskid(), task);
        System.out.println(taskMap);
        return new ResponseEntity(task, HttpStatus.OK);
    }

}
