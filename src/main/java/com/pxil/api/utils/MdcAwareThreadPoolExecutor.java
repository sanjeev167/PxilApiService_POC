/**
 * 
 */
package com.pxil.api.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.MDC;

/**
 * @author sanjeevkumar
 * 23-Dec-2023
 * 6:40:24 pm 
 * Objective : 
 */
public class MdcAwareThreadPoolExecutor extends ThreadPoolExecutor {

    public MdcAwareThreadPoolExecutor(int corePoolSize, 
      int maximumPoolSize, 
      long keepAliveTime, 
      TimeUnit unit, 
      BlockingQueue<Runnable> workQueue, 
      ThreadFactory threadFactory, 
      RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("Cleaning the MDC context");
        MDC.clear();       
        ThreadContext.clearAll();
    }

}//End of MdcAwareThreadPoolExecutor 
