package com.rishiqing.base.push

import com.rishiqing.PushCenter

/**
 * Created by solax on 2016/8/24.
 */
class Config {

    private static Properties push

    public static PROD = 'prod'

    public static DEV = 'dev'

    static {
        push = initializeConfig('push.properties');
    }

    private  static Properties initializeConfig (def key) {
        boolean result = false;
        try {
            Properties config= new Properties();
            String path = PushCenter.getConfigRootPath() ? PushCenter.getConfigRootPath() + '/' + key : key
            InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream(path)
            config .load(is);
            return config
            //this.url = prop.getProperty("betaSocketIoUrl").trim() +  prop.getProperty("betaSocketIoRouter").trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static getIosEnv () {
        return push.iosEnv.trim();
    }
}
