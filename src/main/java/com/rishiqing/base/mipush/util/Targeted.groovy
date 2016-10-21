package com.rishiqing.base.mipush.util

import com.rishiqing.base.push.PushBean
import com.xiaomi.xmpush.server.Message
import com.xiaomi.xmpush.server.TargetedMessage

/**
 * Created by solax on 2016/8/23.
 *
 * 设置目标列表
 */

class Targeted {
    /**
     * 批量发送时，需要设置的目标列表
     * @param message
     * @param config
     * @return
     */
    static List<TargetedMessage> getTargetedMessage (Message message, PushBean bean) {
        try{
            if (!bean || !bean.targetValue) return;
            List<TargetedMessage> targets = [];
            bean.target = bean.target == PushBean.TARGET_ALL ? '' : TargetedMessage.TARGET_TYPE_USER_ACCOUNT
            bean.targetValue.each{ it->
                TargetedMessage target = new TargetedMessage();
                target.setTarget(TargetedMessage.TARGET_TYPE_USER_ACCOUNT, String.valueOf(it));
                target.setMessage(message);
                targets.add(target)
            }
            return targets
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
