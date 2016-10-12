package com.rishiqing.utils

/**
 * Created by Administrator on 2016/10/12.
 */
class ThreadUtil {
    static void executeTread (Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
