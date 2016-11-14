package com.rishiqing.utils

import java.util.concurrent.ThreadPoolExecutor

/**
 * Created by solax on 2016/10/12.
 *
 * 在没有设置过线程池的情况下，默认使用创建线程的方式
 *
 */
class ThreadUtil {

    // 辅助线程池
    private  ThreadPoolExecutor threadPoolExecutor = null

    // 推送默认使用的线程创建方法
     void executeTread (Runnable runnable) {
        if (threadPoolExecutor) {
            threadPoolExecutor.execute(runnable)
        } else {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    // 设置线程池
    public  void setThreadPoolExecutor (ThreadPoolExecutor pool) {
        threadPoolExecutor = pool
    }
}
