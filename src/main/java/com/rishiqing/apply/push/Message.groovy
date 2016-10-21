package com.rishiqing.apply.push

import com.rishiqing.apply.base.AbstractMessage
import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.push.PushBean
import com.rishiqing.utils.ThreadPool
import com.rishiqing.utils.ThreadUtil

/**
 * Created by solax on 2016/8/22.
 */
class Message extends AbstractMessage{
    Message () { super() }
    Message(AbstractPush androidPush, AbstractPush iosPush) {
        super(androidPush, iosPush)
    }
    @Override
    void push(PushBean body) {
        PushBean androidBean = body.clone()
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ androidPush.message.pushAndroid(androidBean) }catch (Exception e){ e.printStackTrace() } }
        })
        PushBean iosBean = body.clone()
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{  iosPush.message.pushIos(iosBean) }catch (Exception e){ e.printStackTrace() } }
        })
    }

    @Override
    void push(PushBean body, Map params) {
        PushBean androidBean = body.clone()
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ androidPush.message.pushAndroid(androidBean, params) }catch (Exception e){ e.printStackTrace() }  }
        })
        PushBean iosBean = body.clone()
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{ iosPush.message.pushIos(iosBean, params) } catch (Exception e){ e.printStackTrace() }
            }
        })
    }
}
