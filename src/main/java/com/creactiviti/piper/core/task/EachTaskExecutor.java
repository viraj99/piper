/* 
 * Copyright (C) Creactiviti LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Arik Cohen <arik@creactiviti.com>, Mar 2017
 */
package com.creactiviti.piper.core.task;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EachTaskExecutor implements TaskExecutor<JobTask>, TaskExecutorResolver {

  private TaskExecutor taskExecutor;
  
  @Override
  public void execute (JobTask aTask) {
    List<Object> list = aTask.getList("list", Object.class);
    Map<String, Object> iteratee = aTask.getMap("iteratee");
    toString();
  }

  @Override
  public TaskExecutor resolve (Task aTask) {
    if(aTask.getType().equals("each")) {
      return this;
    }
    return null;
  }
  
  @Autowired
  public void setTaskExecutor(TaskExecutor aTaskExecutor) {
    taskExecutor = aTaskExecutor;
  }

}
