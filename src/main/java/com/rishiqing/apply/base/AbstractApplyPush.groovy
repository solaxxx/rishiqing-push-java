package com.rishiqing.apply.base

import com.rishiqing.apply.push.phone.Message
import com.rishiqing.apply.push.phone.Notice
import com.rishiqing.base.push.AbstractPush
import com.rishiqing.utils.ThreadUtil

import java.util.concurrent.ThreadPoolExecutor

/**
 * Created by solax on 2016/8/22.
 */
abstract  class AbstractApplyPush {

    protected ThreadUtil threadUtil = new ThreadUtil()

    public AbstractMessage message  =  new Message(this)

    public AbstractMessage notice   =  new Notice(this)

    public void setThreadUtil (ThreadPoolExecutor threadPoolExecutor) {
        this.threadUtil.setThreadPoolExecutor(threadPoolExecutor)
    }

    public ThreadUtil getThreadUtil () {
        return this.threadUtil
    }

    public void addIosPush (AbstractPush push) {
        message.addIosPush(push)
        notice.addIosPush(push)
    }
    public void addAndroidPush (AbstractPush push) {
        message.addAndroidPush(push)
        notice.addAndroidPush(push)
    }
    public void webPush (String roomId, Map map) {}
}
