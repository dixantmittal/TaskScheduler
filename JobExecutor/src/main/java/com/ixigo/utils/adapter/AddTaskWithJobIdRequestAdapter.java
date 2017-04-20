package com.ixigo.utils.adapter;

import com.ixigo.entity.KafkaTaskDetails;
import com.ixigo.taskexecutors.schedulercommons.AddTaskWithJobIdRequest;
import com.ixigo.utils.IxigoDateUtils;

/**
 * Created by dixant on 20/04/17.
 */
public class AddTaskWithJobIdRequestAdapter {
    public static AddTaskWithJobIdRequest adapt(KafkaTaskDetails kafkaTaskDetails) {
        AddTaskWithJobIdRequest request = new AddTaskWithJobIdRequest();
        request.setJobId(kafkaTaskDetails.getJobId());
        request.setRetryJobDetails(kafkaTaskDetails.getRetryJobDetails());
        request.setTaskType(kafkaTaskDetails.getTaskType());
        request.setTaskMetadata(kafkaTaskDetails.getTaskMetadata());
        request.setScheduledTime(IxigoDateUtils.dateToString(kafkaTaskDetails.getScheduledTime()));
        return request;
    }
}