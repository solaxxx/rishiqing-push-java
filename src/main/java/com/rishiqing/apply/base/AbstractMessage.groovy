package com.rishiqing.apply.base

import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.push.PushBean

/**
 * Created by solax on 2016/8/22.
 */
abstract  class AbstractMessage {

    protected AbstractPush androidPush // android推送

    protected AbstractPush iosPush // ios推送

    AbstractMessage () {}

    AbstractMessage (AbstractPush androidPush, AbstractPush iosPush) {
        this.androidPush = androidPush
        this.iosPush = iosPush
    }
    public void setIosPush (def iosPush) {
        this.iosPush = iosPush
    }

    public void setAndroidPush (def androidPush) {
        this.androidPush = androidPush
    }

    public abstract  void push (PushBean body)

    public abstract  void push (PushBean body, Map params)
}
