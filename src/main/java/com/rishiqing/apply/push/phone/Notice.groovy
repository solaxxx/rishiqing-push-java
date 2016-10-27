package com.rishiqing.apply.push.phone

import com.rishiqing.apply.base.AbstractMessage
import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.push.PushBean
import com.rishiqing.utils.ThreadPool
import com.rishiqing.utils.ThreadUtil

/**
 * Created by solax on 2016/8/22.
 */
class Notice  extends AbstractMessage{
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
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ push.notice.pushAndroid(androidBean) }catch (Exception e){ e.printStackTrace() }
            }
        })
    }
    private void pushToIos (AbstractPush push, PushBean pushBean) {
        PushBean iosBean = pushBean.clone()
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ push.notice.pushIos(iosBean) }catch (Exception e){ e.printStackTrace() }
            }
        })
    }
}
