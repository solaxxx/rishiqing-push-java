package com.rishiqing.base.alipush

import com.rishiqing.base.push.IMessage
import com.rishiqing.base.alipush.util.BeanConfig
import com.rishiqing.base.alipush.util.Builder
import com.rishiqing.base.push.PushBean


/**
 * Created by solax on 2016/8/25.
 */
class Message  implements IMessage{

    @Override
    void pushAndroid(PushBean body) {
        body.aliType = 0 // 消息模式
        BeanConfig.getAliPushBean(body)
        Builder.pushToAndroid(body)
    }

    @Override
    void pushAndroid(PushBean body, Map params) {
        this.pushAndroid(body);
    }

    @Override
    void pushIos(PushBean body) {
        body.aliType = 0 // 消息模式
        BeanConfig.getAliPushBean(body)
        Builder.pushToIos(body)
    }

    @Override
    void pushIos(PushBean body, Map params) {
        this.pushIos(body);
    }
}
