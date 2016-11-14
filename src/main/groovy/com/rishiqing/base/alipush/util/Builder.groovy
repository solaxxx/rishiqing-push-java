package com.rishiqing.base.alipush.util

import com.aliyuncs.DefaultAcsClient
import com.aliyuncs.profile.DefaultProfile
import com.aliyuncs.profile.IClientProfile
import com.aliyuncs.push.model.v20150827.PushRequest
import com.aliyuncs.push.model.v20150827.PushResponse
import com.rishiqing.base.push.PushBean
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper



/**
 * Created by solax on 2016/8/25.
 */
class Builder {

    /**
     * 向android推送消息
     * @param body
     */
    static void pushToAndroid (PushBean body) {
        body.deviceType = 1
        push(body);
    }

    /**
     * 向IOS推送消息
     * @param body
     */
    static void pushToIos(PushBean body) {
        body.deviceType = 0
        push(body)
    }

    /**
     * 推送消息
     * @param body
     */
    static void push (PushBean body) {
        IClientProfile profile = DefaultProfile.getProfile("cn-beijing", AliPushConfig.getAccessKeyId(), AliPushConfig.getAccessKeySecret());
        DefaultAcsClient client = new DefaultAcsClient(profile);
        PushRequest pushRequest = new PushRequest();
// 推送目标
        pushRequest.setAppKey(Long.parseLong(AliPushConfig.getAppKey()));
        pushRequest.setTarget(body.target == PushBean.TARGET_ALL ? PushBean.TARGET_ALL : body.aliTarget); //推送目标: device:推送给设备; account:推送给指定帐号,tag:推送给自定义标签; all: 推送给全部
        pushRequest.setTargetValue(body.targetValue ? body.targetValue : '1'); //根据Target来设定，如Target=device, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
        pushRequest.setDeviceType(body.deviceType); // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3, 这是默认值.
        // 推送配置
        pushRequest.setType(body.aliType); // 0:表示消息(默认为0), 1:表示通知
        pushRequest.setTitle(body.title?body.title:'日事清消息'); // 消息的标题
        pushRequest.setBody(body.description); // 消息的内容
        pushRequest.setSummary(body.title?body.title:'摘要'); // 通知的摘要
// 推送配置: iOS
        pushRequest.setiOSBadge("5"); // iOS应用图标右上角角标
        pushRequest.setiOSMusic("default"); // iOS通知声音
        pushRequest.setiOSExtParameters("{\"k1\":\"ios\",\"k2\":\"v2\"}"); //自定义的kv结构,开发者扩展用 针对iOS设备
        pushRequest.setApnsEnv("DEV");
// pushRequest.setRemind(true); // 当APP不在线时候，是否通过通知提醒
// 推送配置: Android
        pushRequest.setAndroidOpenType("1"); // 点击通知后动作,1:打开应用 2: 打开应用Activity 3:打开 url
        // pushRequest.setAndroidOpenUrl("http://www.baidu.com"); // Android收到推送后打开对应的url,仅仅当androidOpenType=3有效
        pushRequest.setAndroidExtParameters(mapToJson(body.extra)); // 设定android类型设备通知的扩展属性
        pushRequest.setStoreOffline(true);
        PushResponse pushResponse = client.getAcsResponse(pushRequest);
        printStack(pushResponse)
    }

    static String mapToJson (map) {
        return  new JsonBuilder( map ).toPrettyString()
    }

    static void printStack (PushResponse result) {
        if (result && result.message)  {
            println('huawei push :' + result.message)
        }
    }
}
