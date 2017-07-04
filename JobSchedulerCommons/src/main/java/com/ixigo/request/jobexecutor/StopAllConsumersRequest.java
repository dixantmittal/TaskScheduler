package com.ixigo.request.jobexecutor;

import com.ixigo.exception.constants.RequestValidationExceptionConstants;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by dixant on 04/04/17.
 */
@Data
public class StopAllConsumersRequest {
    @NotBlank(message = RequestValidationExceptionConstants.TOPIC_NAME_IS_BLANK)
    private String topic;
}
