package com.rishiqing.base.webpush.util

import com.rishiqing.base.push.Config
import com.xiaomi.xmpush.server.Constants

/**
 * Created by solax on 2016/8/25.
 */
class WebPushConfig extends Config{

    private static Properties webPush = initializeConfig('webPush-config.properties');
    private static Map configMap = [:]

    static getWebSocketUrl () {
        def webSocketUrl = configMap.get("web.socket.url")
        if(webSocketUrl){
            return webSocketUrl
        }
        return webPush."web.socket.url".trim()
    }
    static getRouter () {
        // return webPush.router.trim()
    }
    static getAuthCode () {
        def authCode = configMap.get("web.auth.code")
        if(authCode){
            return authCode
        }
        return webPush."web.auth.code".trim()
    }
    static initConfigMap(Map map){
        configMap = map
    }
}
