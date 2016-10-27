package com.rishiqing.apply.base

import com.rishiqing.apply.push.phone.Message
import com.rishiqing.apply.push.phone.Notice
import com.rishiqing.base.push.AbstractPush

/**
 * Created by solax on 2016/8/22.
 */
abstract  class AbstractApplyPush {
    public AbstractMessage message  =  new Message()

    public AbstractMessage notice   =  new Notice()

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
