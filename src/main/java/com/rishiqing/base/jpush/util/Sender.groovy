package com.rishiqing.base.jpush.util

import cn.jpush.api.JPushClient
import cn.jpush.api.common.resp.APIConnectionException
import cn.jpush.api.common.resp.APIRequestException
import cn.jpush.api.push.PushResult
import cn.jpush.api.push.model.PushPayload
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * Created by solax on 2016/10/24.
 */
class Sender {

    protected static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    static def send (PushPayload payload) {
        try {
            JPushClient jpushClient = new JPushClient(JPushConfig.masterSecret, JPushConfig.appKey, 3);
            PushResult result = jpushClient.sendPush(payload);
            //println("Got result - " + result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            println("Connection error, should retry later");
        } catch (APIRequestException e) {
            // Should review the error, and fix the request
           if (1011 != e.getErrorCode()) {
                println("HTTP Status: " + e.getStatus());
                println("Error Code: " + e.getErrorCode());
                println("Error Message: " + e.getErrorMessage());
           }
        }
    }
}
