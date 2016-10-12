package com.rishiqing.base.alipush.util

import com.rishiqing.base.push.Config

/**
 * Created by solax on 2016/8/25.
 */
class AliPushConfig  extends Config {
    private static Properties aliPush = initializeConfig('aliPush-config.properties');

    static String getAppKey () {
        return aliPush.appKey.trim()
    }
    static String getAccessKeyId () {
        return aliPush.accessKeyId.trim()
    }
    static String getAccessKeySecret () {
        return aliPush.accessKeySecret.trim()
    }
}
