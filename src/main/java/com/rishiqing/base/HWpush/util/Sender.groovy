package com.rishiqing.base.HWpush.util

import com.alibaba.fastjson.JSONObject
import nsp.NSPClient
import nsp.OAuth2Client
import nsp.support.common.AccessToken

/**
 * Created by solax on 2016/11/2.
 */
class Sender {

    static def send (HashMap<String, Object> body) {

        //  获取token
        AccessToken access_token = HWToken.getInstance()
        NSPClient client = new NSPClient(access_token.getAccess_token());
        client.initHttpConnections(HWPushConfig.getMinConnection(), HWPushConfig.getMaxConnection());//设置每个路由的连接数和最大连接数
        client.initKeyStoreStream(HWPushConfig.getCloneStream(), HWPushConfig.getOauth2Password());
        //设置http超时时间
        client.setTimeout(10000, 15000);
        //接口调用
        String rsp = client.call("openpush.openapi.notification_send", body, String.class);
        printStack(rsp);
    }

    static def printStack (String rsq) {
        JSONObject jsonObject = JSONObject.parse(rsq)
        if (jsonObject.get('result_code') != 0) {
            println('HUAWEI PUSH ERROR : id_' + jsonObject.get('request_id') +', ' + jsonObject.get('result_desc'))
        }
    }
}
