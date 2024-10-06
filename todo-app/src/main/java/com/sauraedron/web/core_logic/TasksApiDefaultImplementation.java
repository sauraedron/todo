package com.sauraedron.web.core_logic;

import com.sauraedron.TasksApi;
import com.sauraedron.models.entities.Task;
import com.sauraedron.wire_models.MasterTask;
import com.sauraedron.wire_models.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class TasksApiDefaultImplementation implements TasksApi {

    Map<UUID, MasterTask> taskMap = new ConcurrentHashMap<>();

    @Autowired
    TaskDB taskDB;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return TasksApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<MasterTask>> getTasks() {
        return new ResponseEntity<>(new ArrayList<>(this.taskMap.values()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MasterTask> createTask(TaskRequest taskRequest) {
        Task t = taskDB.save(taskRequest);
        return new ResponseEntity(t, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MasterTask> getTaskById(String taskId) {
        if(this.taskMap.containsKey(UUID.fromString(taskId)))
            return new ResponseEntity<>(this.taskMap.get(UUID.fromString(taskId)), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public void setTaskDB(TaskDB taskDB) {
        this.taskDB = taskDB;
    }
}
