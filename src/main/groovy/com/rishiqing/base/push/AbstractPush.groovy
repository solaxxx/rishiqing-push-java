package com.rishiqing.base.push;

import java.lang.reflect.Proxy;

/**
 * Created by solax on 2016/8/22.
 */
public abstract class AbstractPush {
    public IMessage message;
    public IMessage notice;

    public void setMessage(IMessage message) {

       this.message = message;
       // this.message = this.generateProxy(message);
    }

    public void setNotice(IMessage notice) {
       this.notice = notice;
       // this.notice = this.generateProxy(notice);
    }
}
