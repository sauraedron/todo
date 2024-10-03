package com.sauraedron;

import com.sauraedron.wire_models.MasterTask;
import com.sauraedron.wire_models.TaskRequest;
import jakarta.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-10-03T12:37:08.841886200+05:30[Asia/Calcutta]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.tODO.base-path:}")
public class TasksApiController implements TasksApi {

    @Autowired
    TasksApi tasksApi;

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
    public ResponseEntity<TaskRequest> getTaskById(String taskId) {
        return TasksApi.super.getTaskById(taskId);
    }

    @Override
    public ResponseEntity<List<MasterTask>> getTasks() {
        return TasksApi.super.getTasks();
    }

    @Override
    public ResponseEntity<MasterTask> taskRequest(TaskRequest taskRequest) {
        return this.tasksApi.taskRequest(taskRequest);
    }

    @Override
    public ResponseEntity<MasterTask> createTask(TaskRequest taskRequest) {
        return this.tasksApi.taskRequest(taskRequest);
    }

    public void setTasksApi(TasksApi tasksApi) {
        this.tasksApi = tasksApi;
    }
}
