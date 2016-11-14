package com.rishiqing.base.jpush.util

import com.rishiqing.base.push.Config

/**
 * Created by Administrator on 2016/10/24.
 */
class JPushConfig  extends Config  {

    public static PROD = 'prod'

    public static DEV ='dev'

    private static Properties jPush = initializeConfig('jPush-config.properties');



    static getAppKey () {
        return jPush.appKey.trim();
    }

    static getMasterSecret () {
        return jPush.masterSecret.trim();
    }

    static getUtl () {
        return jPush.url.trim();
    }
}
