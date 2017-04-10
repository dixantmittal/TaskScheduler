package com.ixigo.dao.impl;

import com.ixigo.dao.ITaskDao;
import com.ixigo.dbmapper.ITaskHistoryMapper;
import com.ixigo.dbmapper.entity.TaskHistoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dixant on 03/04/17.
 */
@Service
@Slf4j
public class TaskDaoImpl implements ITaskDao {

    @Autowired
    ITaskHistoryMapper taskMapper;

    @Override
    public Boolean addTaskHistory(TaskHistoryEntity params) {
        Integer rowsAffected = taskMapper.addTaskHistory(params);
        if (rowsAffected == 0) {
            log.error("Error occurred while adding entry to database. Entity: {}", params);
            return false;
        }
        return true;
    }
}
