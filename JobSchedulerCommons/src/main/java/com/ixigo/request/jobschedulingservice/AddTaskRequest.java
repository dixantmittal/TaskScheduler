package com.ixigo.request.jobschedulingservice;

import com.ixigo.entity.RetryJobDetails;
import com.ixigo.validation.jobschedulingservice.AddTaskRequestValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Created by dixant on 27/03/17.
 */
@Data
@AddTaskRequestValidation
@NoArgsConstructor
@AllArgsConstructor
public class AddTaskRequest {
    private String taskType;
    private String taskMetadata;
    private Timestamp scheduledTime;
    private Integer priority;
    private RetryJobDetails retryJobDetails;
    private Boolean canRetry;

    public AddTaskRequest(AddTaskRequest ob) {
        taskType = ob.taskType;
        taskMetadata = ob.taskMetadata;
        scheduledTime = ob.scheduledTime;
        priority = ob.priority;
        retryJobDetails = ob.retryJobDetails;
        canRetry = ob.canRetry;
    }
}
