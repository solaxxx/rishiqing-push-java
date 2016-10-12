package com.rishiqing.apply.base

import com.rishiqing.apply.push.Message
import com.rishiqing.apply.push.Notice
import com.rishiqing.base.push.AbstractPush

/**
 * Created by solax on 2016/8/22.
 */
abstract  class AbstractApplyPush {

    public AbstractMessage message  =  new Message()

    public AbstractMessage notice   =  new Notice()

    // public AbstractMessage messageOffline  =  new MessageOffline()

    // public AbstractMessage noticeOffline   =  new NoticeOffline()

    AbstractApplyPush(){}

    AbstractApplyPush(AbstractPush mainPush, AbstractPush push) {
        this.setPush(mainPush, push);
    }
    public setPush (AbstractPush androidPush, AbstractPush iosPush) {
        this.setMessage(androidPush, iosPush)
        this.setNotice(androidPush, iosPush)
        // this.setMessageOffline(androidPush, iosPush)
        // this.setNoticeOffline(androidPush, iosPush)
    }

    protected void setMessage (AbstractPush androidPush, AbstractPush iosPush) {
        this.message.setAndroidPush(androidPush)
        this.message.setIosPush(iosPush)
    }
    protected void setNotice (AbstractPush androidPush, AbstractPush iosPush) {
        this.notice.setAndroidPush(androidPush)
        this.notice.setIosPush(iosPush)
    }
    protected void setMessageOffline (AbstractPush androidPush, AbstractPush iosPush) {
        // this.messageOffline.setAndroidPush(androidPush)
        // this.messageOffline.setIosPush(iosPush)
    }
    protected void setNoticeOffline (AbstractPush androidPush, AbstractPush iosPush) {
        // this.noticeOffline.setAndroidPush(androidPush)
        // this.noticeOffline.setIosPush(iosPush)
    }
}
