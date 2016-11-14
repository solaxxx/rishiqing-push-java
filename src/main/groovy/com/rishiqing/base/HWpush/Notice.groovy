package com.rishiqing.base.HWpush

import com.rishiqing.base.HWpush.util.BeanConfig
import com.rishiqing.base.HWpush.util.Builder
import com.rishiqing.base.HWpush.util.Sender
import com.rishiqing.base.push.IMessage
import com.rishiqing.base.push.PushBean

/**
 * Created by solax on 2016/11/2.
 */
class Notice  implements IMessage{
    void pushAndroid(PushBean pushBean) {
        BeanConfig.getHuaweiPushBean(pushBean)
        def map = Builder.getMessage(pushBean)
        Sender.send(map)
    }

    void pushAndroid(PushBean body, Map params) {

    }

    void pushIos(PushBean body) {

    }

    void pushIos(PushBean body, Map params) {

    }
}
