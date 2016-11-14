package com.rishiqing.base.jpush.util

import cn.jpush.api.push.model.Message
import cn.jpush.api.push.model.Options
import cn.jpush.api.push.model.Platform
import cn.jpush.api.push.model.PushPayload
import cn.jpush.api.push.model.audience.Audience
import cn.jpush.api.push.model.notification.AndroidNotification
import cn.jpush.api.push.model.notification.IosNotification
import cn.jpush.api.push.model.notification.Notification
import com.rishiqing.base.push.Config
import com.rishiqing.base.push.PushBean
import com.rishiqing.utils.PushCommonUtil
import org.json.simple.JSONObject

/**
 * Created by solax on 2016/10/24.
 */
class Builder {
    static String ALERT = '日事清提醒'

    static def getIosMessage (PushBean pushBean) {
        getMessage2(pushBean, 'ios')
    }

    static def getAndroidMessage (PushBean pushBean) {
        getMessage2(pushBean, 'android')
    }

    static def getMessage2 (PushBean pushBean, String platform) {
        String title = pushBean.title ? pushBean.title:pushBean.description

        String receiverValue = pushBean.targetValue
        if (pushBean.target == PushBean.TARGET_ALL) {
            return  PushPayload.alertAll(title);
        }
        PushPayload.Builder builder =  PushPayload.newBuilder()
        builder.setAudience(Audience.alias(receiverValue))
        Platform p
        if (platform == 'android') {
            p = Platform.android()
            //builder.setNotification(Notification.android(ALERT, title, null))
            AndroidNotification.Builder androidNotificationBuilder = AndroidNotification.newBuilder()
            androidNotificationBuilder
                    .setAlert(title)
                    .addExtra("jPush", true)
            if (pushBean.extra) {
                pushBean.extra.each{ key, value ->
                    androidNotificationBuilder.addExtra(key, value)
                }
            }
            AndroidNotification ab = androidNotificationBuilder.build()
            builder.setNotification(Notification.newBuilder().addPlatformNotification(ab).build())
        } else if (platform == 'ios') {
            p = Platform.ios()
            IosNotification.Builder iosNotificationBuilder = IosNotification.newBuilder()
            iosNotificationBuilder
                    .setAlert(title)
                    .setBadge(1)
                    .setSound(pushBean.soundURL)
                    .addExtra("jPush", true)
            if (pushBean.extra) {
                pushBean.extra.each{ key, value ->
                    iosNotificationBuilder.addExtra(key, value)
                }
            }
            IosNotification ab = iosNotificationBuilder.build()
            builder.setNotification(Notification.newBuilder().addPlatformNotification(ab).build())
            if (Config.iosEnv == Config.PROD) {
                builder .setOptions(Options.newBuilder()
                        .setApnsProduction(true)
                        .build())
            }
        }
        builder.setPlatform(p)
        builder.setMessage(Message.content(pushBean.description))
        return  builder.build()
    }

    static def getMessage (PushBean pushBean, String platform) {
        def title = pushBean.title ? pushBean.title : pushBean.description
        JSONObject jsonContent = new JSONObject()
        jsonContent.put("title", title)
        jsonContent.put("message",pushBean.description)
        jsonContent.put("n_content",title)
        //jsonContent.put("n_extras",JSONObject .parse("{'jPush': true}"))
        pushBean.addExtra('jPush','true')
        def extra = PushCommonUtil.mapToJson(pushBean.extra)
        jsonContent.put('n_extras', extra)
        int receiverType = 3
        int msgType = 1
        String sendNo = 'rishiqing'
        String receiverValue = BeanConfig.getJPushPushBean(pushBean)
        String veriReceiverValue = String.valueOf(receiverValue).replace("@","1").replace(".","1")
        String masterKey = JPushConfig.getMasterSecret()
        def params = [:]
        params.sendno = sendNo
        params.app_key = JPushConfig.getAppKey()
        params.receiver_type = String.valueOf(receiverType)
        params.receiver_value = veriReceiverValue
        params.verification_code = generateVerificationCode(
                sendNo,
                receiverType,
                veriReceiverValue,
                masterKey)
        params.msg_type = String.valueOf(msgType)
        params.msg_content =jsonContent.toString()
        params.platform = platform
        params.apns_production = "1"
/*        List<NameValuePair> params = [
                new BasicNameValuePair("sendno", sendNo),
                new BasicNameValuePair("app_key",JPushConfig.getAppKey()),
                new BasicNameValuePair("receiver_type",String.valueOf(receiverType)),
                new BasicNameValuePair("receiver_value",veriReceiverValue),
                new BasicNameValuePair("verification_code",
                        generateVerificationCode(
                                sendNo,
                                receiverType,
                                veriReceiverValue,
                                masterKey)
                ),
                new BasicNameValuePair("msg_type",String.valueOf(msgType)),
                new BasicNameValuePair("msg_content",jsonContent.toString()),
                new BasicNameValuePair("platform", platform),
                new BasicNameValuePair("apns_production","1")
        ]*/
        return params
    }

    static def generateVerificationCode(String sendno, int receiverType,String receiverValue, String masterSecret) {
        String input = String.valueOf(sendno) + receiverType + receiverValue + masterSecret;
        String md5 = PushCommonUtil.stringToMD5(input)
        return md5
    }

}
