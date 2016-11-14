package com.rishiqing.base.mipush.util

import com.rishiqing.base.push.Config
import com.xiaomi.xmpush.server.Constants

/**
 * Created by solax on 2016/8/25.
 */
class MiPushConfig extends Config{

    private static PROD = 'prod'

    private static DEV = 'dev'

    private static Properties miPush = initializeConfig('miPush-config.properties');

    static getAppSecretAndroid () {
        return miPush.appSecretAndroid.trim()
    }

    static getAppSecretIos() {
        return miPush.appSecretIos.trim()
    }

    static getPackageName () {
        return miPush.packageName.trim()
    }

    static getTimeToLive () {
        return miPush.timeToLive.trim();
    }

    static userEnvironment () {
        def model = getIosEnv()
        switch (model) {
            case PROD:
                Constants.useOfficial();
                break;
            case DEV :
                Constants.useSandbox();
                break;
            default:
                break;
        }
    }
}
