package com.rishiqing.base.mipush.util

import com.rishiqing.base.push.PushBean
import com.xiaomi.xmpush.server.Message

/**
 * Created by solax on 2016/8/23.
 *
 * 构建消息体
 *
 */
class Builder {
    /**
     * 构建android builder message
     * @param body
     * @return
     */
     static Message getAndroidMessage (PushBean body) {
        if (!body)  return;body.appSecret = MiPushConfig.getAppSecretAndroid();
         body.deviceRecord = 0
         Message.Builder builder =  new Message.Builder()
         builder .title(body.title)
                 .description(body.description).payload(body.messagePayload)
                 .restrictedPackageName(MiPushConfig.getPackageName())
                 .passThrough(body.passThrough)    // 消息使用透传方式
                 .notifyType(body.notifyType)      // 使用默认提示音提示
                 .timeToLive(body.timeToLive)      // 离线保存时间，默认不离线保存
         if (body.extra) {
             body.extra.each{ key, value ->
                 builder.extra(key, value)
             }
         }
         Message message = builder.build()
        return message;
    }

    /**
     * ios builder message
     * @param body
     * @return
     */
     static Message getIosMessage (PushBean body) {
         try{
             if (!body)  return; body.appSecret = MiPushConfig.getAppSecretIos();
             body.deviceRecord = 1
             String description;
             if (body.title) {
                 description = body.title
             }  else {
                 description = body.description?body.description :"notification description";
             }
             Message.IOSBuilder builder =  new Message.IOSBuilder()
             builder.description(description)
                     .soundURL(body.soundURL)    // 消息铃声
                     .badge(Integer.parseInt(body.badge))               // 数字角标
                     .category(body.category)     // 快速回复类别
                     .timeToLive(body.timeToLive)      // 离线保存时间，默认不离线保存
             if (body.extra) {
                 body.extra.each{ key, value ->
                     builder.extra(key, value)
                 }
             }
             Message message = builder.build()
             return message;
         } catch (Exception e) {
             e.printStackTrace()
         }
    }
}
