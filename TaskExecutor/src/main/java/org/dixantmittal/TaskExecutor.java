package org.dixantmittal;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.dixantmittal.builder.ConsumerBuilder;
import org.dixantmittal.cache.TaskExecutorCache;
import org.dixantmittal.consumer.Consumer;
import org.dixantmittal.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

/**
 * Created by dixant on 24/03/17.
 */
@SpringBootApplication
@Slf4j
public class TaskExecutor implements CommandLineRunner {
    @Autowired
    TaskExecutorCache cache;

    public static void main(String[] args) {
        if (args.length < 2) {
            log.error("Correct syntax is: java -jar TaskExecutor <Task Type> <Topic Name>");
            return;
        }
        new SpringApplicationBuilder(TaskExecutor.class).web(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        String taskType = args[0];
        String topic = args[1];
        Properties properties;
        (properties = new Properties()).load(this.getClass().getClassLoader().getResourceAsStream("kafka.properties"));
        ConsumerBuilder.<String, Task>newConsumer()
                .withProperties(properties)
                .withTopics(topic)
                .withGroupId(properties.getProperty("group.id"))
                .withProcessor(new Consumer.Processor<String, Task>() {
                    @Override
                    protected Boolean process(ConsumerRecords<String, Task> records) {
                        for (ConsumerRecord<String, Task> record : records) {
                            cache.getTaskExecutor(taskType).execute(record.value());
                        }
                        return true;
                    }
                })
                .getConsumer()
                .start();
    }
}
