package com.rishiqing.apply.base

import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.push.PushBean
import com.rishiqing.utils.ThreadUtil

import java.util.concurrent.ThreadPoolExecutor

/**
 * Created by solax on 2016/8/22.
 */
abstract  class AbstractMessage {

    protected ThreadUtil threadUtil

    AbstractMessage (AbstractApplyPush push) {
        threadUtil = push.getThreadUtil()
    }

    public void setThreadUtil (ThreadPoolExecutor threadPoolExecutor) {
        this.threadUtil.setThreadPoolExecutor(threadPoolExecutor)
    }
    // ios 推送对象list
    protected List<AbstractPush> iosPush = []

    // android 推送对象list
    protected List<AbstractPush>  androidPush = []


    public void addIosPush (AbstractPush push) {
        iosPush.add(push)
    }
    public void addAndroidPush (AbstractPush push) {
        androidPush.add(push)
    }

    public abstract  void push (PushBean body)
}
