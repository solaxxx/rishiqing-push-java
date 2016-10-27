package com.rishiqing.base.webpush.util

import com.rishiqing.base.push.Config
import com.xiaomi.xmpush.server.Constants

/**
 * Created by solax on 2016/8/25.
 */
class WebPushConfig extends Config{

    private static Properties webPush = initializeConfig('webPush-config.properties');

    static getWebSocketUrl () {
        return webPush.webSocketUrl.trim()
    }
    static getRouter () {
        // return webPush.router.trim()
    }
    static getAuthCode () {
        return webPush.authCode.trim()
    }
}
