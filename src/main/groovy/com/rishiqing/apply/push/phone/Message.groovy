package com.rishiqing.apply.push.phone

import com.rishiqing.apply.base.AbstractApplyPush
import com.rishiqing.apply.base.AbstractMessage
import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.push.PushBean
import com.rishiqing.utils.ThreadPool
import com.rishiqing.utils.ThreadUtil

/**
 * Created by solax on 2016/8/22.
 */
class Message extends AbstractMessage{

    Message(AbstractApplyPush push) {
        super(push)
    }

    @Override
    void push(PushBean body) {
        this.iosPush.each{ it ->
            this.pushToIos(it, body)
        }
        this.androidPush.each{ it ->
            this.pushToAndroid(it, body)
        }
    }
    private void pushToAndroid (AbstractPush push, PushBean pushBean) {
        PushBean androidBean = pushBean.clone()
        this.threadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ push.message.pushAndroid(androidBean) }catch (Exception e){ e.printStackTrace() }
            }
        })
    }
    private void pushToIos (AbstractPush push, PushBean pushBean) {
        PushBean iosBean = pushBean.clone()
        this.threadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ push.message.pushIos(iosBean) }catch (Exception e){ e.printStackTrace() }
            }
        })
    }
}
