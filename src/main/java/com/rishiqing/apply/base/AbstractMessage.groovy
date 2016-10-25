package com.rishiqing.apply.base

import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.push.PushBean

/**
 * Created by solax on 2016/8/22.
 */
abstract  class AbstractMessage {
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
