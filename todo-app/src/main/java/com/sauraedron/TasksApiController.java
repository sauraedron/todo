package com.sauraedron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-03T00:03:26.800859800+05:30[Asia/Calcutta]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.tODO.base-path:}")
public class TasksApiController implements TasksApi {

    private final NativeWebRequest request;

    @Autowired
    public TasksApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<MasterTask> createTask(CreateTask createTask) {
        return TasksApi.super.createTask(createTask);
    }

    @Override
    public ResponseEntity<CreateTask> getTaskById(String taskId) {
        return TasksApi.super.getTaskById(taskId);
    }

    @Override
    public ResponseEntity<List<MasterTask>> getTasks() {
        return TasksApi.super.getTasks();
    }
}
