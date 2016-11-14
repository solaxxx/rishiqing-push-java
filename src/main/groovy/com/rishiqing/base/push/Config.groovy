package com.rishiqing.base.push

import com.rishiqing.PushCenter
import com.rishiqing.utils.InputStreamCache

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
        try {
            Properties config= new Properties();
            String path = PushCenter.getConfigRootPath() ? PushCenter.getConfigRootPath() + '/' + key : key
            InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream(path)
            config .load(is);
            return config
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStreamCache getStream (def key) {
        try {
            String path = PushCenter.getConfigRootPath() ? PushCenter.getConfigRootPath() + '/' + key : key
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)
            // 加入input缓存以重复利用
            InputStreamCache inputStreamCache = new InputStreamCache()
            inputStreamCache.setInputStreamCache(is)
            return inputStreamCache
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static getIosEnv () {
        return push.iosEnv.trim();
    }
}
