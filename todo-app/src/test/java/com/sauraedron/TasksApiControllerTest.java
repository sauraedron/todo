package com.sauraedron;

import com.sauraedron.wire_models.MasterTask;
import com.sauraedron.wire_models.TaskRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {com.sauraedron.web.OpenApiGeneratorApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TasksApiControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    TasksApiController tasksApiController;

    @Test
    void contextLoads() {
        assertNotNull(tasksApiController);
    }

    @Test
    void createAndFetchTest() {
        String expectedTaskDesc = "Task1";
        TaskRequest taskRequest = TaskRequest.builder().description(expectedTaskDesc).build();
        String url = "http://localhost:" + port + "/tasks";
        testRestTemplate.postForEntity(url, taskRequest, TaskRequest.class);
        List<MasterTask> fetchedTasks =     testRestTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<MasterTask>>(){}).getBody();
        assertEquals(expectedTaskDesc, fetchedTasks.get(0).getDescription());

    }
}