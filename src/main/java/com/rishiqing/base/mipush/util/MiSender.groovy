package com.rishiqing.base.mipush.util

import com.rishiqing.base.push.PushBean
import com.xiaomi.xmpush.server.*

/**
 * Created by solax on 2016/8/23.
 *
 * miPush sender
 */
class MiSender {
    /**
     * 发送regIds
     * @param message
     * @param body
     */
     static  void sendToRegId (Message message, PushBean body) {
         MiPushConfig.userEnvironment()
         int rePush =  body.rePush?body.rePush:0 //  0不重试
         Sender sender = new Sender(body.appSecret);
         Result result = sender.send(message, body.regId, rePush); //根据regID，发送消息到指定设备上，不重试。
         printStack(result)
    }

    /**
     * 发送alias
     * @param message
     * @param body
     */
    static void sendToAlias (Message message, PushBean body) {
        MiPushConfig.userEnvironment()
        int rePush =  body.rePush?body.rePush:0 //  0不重试
        Sender sender = new Sender(body.appSecret);
        Result result = sender.send(message, body.alias, rePush); //根据regID，发送消息到指定设备上，不重试。
        printStack(result)
    }

    /**
     * 批量发送，可以发送 alias 或 regIds
     * @param messages
     * @param body
     */
    static void sendToList (List<TargetedMessage> messages, PushBean body) {
        MiPushConfig.userEnvironment()
        int rePush =  body.rePush?body.rePush:0//  0不重试
        Sender sender = new Sender(body.appSecret);
        Result result = sender.send(messages, rePush); //根据regID，发送消息到指定设备上，不重试。
        printStack(result)
    }

    static void sendToAll (Message message, PushBean body) {
        MiPushConfig.userEnvironment()
        Sender sender = new Sender(body.appSecret);
        Result result = sender.broadcastAll(message, 0)
        printStack(result)
    }

    static void printStack (Result result) {
        if (result && result.getReason())  {
            println(result.getReason())
        }
    }
}
