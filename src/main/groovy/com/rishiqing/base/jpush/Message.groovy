package com.rishiqing.base.jpush

import com.rishiqing.base.jpush.util.BeanConfig
import com.rishiqing.base.jpush.util.Builder
import com.rishiqing.base.jpush.util.Sender
import com.rishiqing.base.push.IMessage
import com.rishiqing.base.push.PushBean

/**
 * Created by solax on 2016/10/24.
 */
class Message  implements IMessage {
    void pushAndroid(PushBean body) {
        BeanConfig.getJPushPushBean(body)
        def message = Builder.getAndroidMessage(body)
        Sender.send(message)
    }

    void pushAndroid(PushBean body, Map params) {
        this.pushAndroid(body);
    }

    void pushIos(PushBean body) {
        BeanConfig.getJPushPushBean(body)
        def message = Builder.getIosMessage(body)
        Sender.send(message)
    }

    void pushIos(PushBean body, Map params) {
        this.pushIos(body);
    }
}
