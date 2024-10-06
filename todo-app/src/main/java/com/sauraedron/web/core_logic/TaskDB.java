package com.sauraedron.web.core_logic;

import com.sauraedron.models.entities.Task;
import com.sauraedron.wire_models.TaskRequest;

public interface TaskDB {

    public Task save(TaskRequest task);
}
