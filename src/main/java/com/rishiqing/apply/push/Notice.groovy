package com.rishiqing.apply.push

import com.rishiqing.apply.base.AbstractMessage
import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.push.PushBean
import com.rishiqing.utils.ThreadPool
import com.rishiqing.utils.ThreadUtil

/**
 * Created by solax on 2016/8/22.
 */
class Notice  extends AbstractMessage{

    Notice () { super() }

    Notice(AbstractPush androidPush, AbstractPush iosPush) {
        super(androidPush, iosPush)
    }

    @Override
    void push(PushBean body) {
        PushBean androidBean = body.clone()
       ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ androidPush.notice.pushAndroid(androidBean) }catch (Exception e){ e.printStackTrace() }
            }
        })
        PushBean iosBean = body.clone()
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{  iosPush.notice.pushIos(iosBean) }catch (Exception e){ e.printStackTrace() }
            }
        })
    }

    @Override
    void push(PushBean body, Map params) {
        PushBean androidBean = body.clone()
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ androidPush.notice.pushAndroid(androidBean, params) }catch (Exception e){ e.printStackTrace() }
            }
        })
        PushBean iosBean = body.clone()
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ iosPush.notice.pushIos(iosBean, params) }catch (Exception e){ e.printStackTrace() }
            }
        })
    }
}
