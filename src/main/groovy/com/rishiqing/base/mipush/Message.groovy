package com.rishiqing.base.mipush

import com.rishiqing.base.push.IMessage
import com.rishiqing.base.mipush.util.BeanConfig
import com.rishiqing.base.mipush.util.Builder
import com.rishiqing.base.mipush.util.MiSender
import com.rishiqing.base.mipush.util.Targeted
import com.rishiqing.base.push.PushBean
import com.xiaomi.xmpush.server.Result
import com.xiaomi.xmpush.server.TargetedMessage

/**
 * Created by solax on 2016/8/22.
 */
class Message implements IMessage{
    @Override
    void pushAndroid(PushBean body) {
        body.passThrough = 1;
        BeanConfig.getMiPushBean(body)
        def message = Builder.getAndroidMessage(body)
        if (body.target == PushBean.TARGET_ALL) {
            MiSender.sendToAll(message, body)
            return
        }
        List<TargetedMessage> targets = Targeted.getTargetedMessage(message, body)
        MiSender.sendToList(targets, body)
    }

    @Override
    void pushAndroid(PushBean body, Map params) {
        this.pushAndroid(body);
    }

    @Override
    void pushIos(PushBean body) {
        body.passThrough = 1;
        def config = BeanConfig.getMiPushBean(body)
        def message = Builder.getIosMessage(config)
        if (body.target == PushBean.TARGET_ALL) {
            MiSender.sendToAll(message, body)
            return
        }
        List<TargetedMessage> targets = Targeted.getTargetedMessage(message, config)
        MiSender.sendToList(targets, config)
    }

    @Override
    void pushIos(PushBean body, Map params) {
        this.pushIos(body);
    }

}
