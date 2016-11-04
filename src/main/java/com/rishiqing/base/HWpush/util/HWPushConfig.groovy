package com.rishiqing.base.HWpush.util

import com.rishiqing.base.push.Config
import com.rishiqing.utils.InputStreamCache

import java.lang.reflect.Field

/**
 * Created by solax on 2016/11/2.
 */
class HWPushConfig  extends Config {

    private static Properties HWPush = initializeConfig('huaweiPush-config.properties');

    private static InputStreamCache JKSStreamCache = getStream('mykeystorebj.jks')

    static String  getOauth2Password () {
        return HWPush.oauth2Password.trim()
    }

    static InputStream getCloneStream () {
/*        InputStream inputStream = new InputStream() {
            @Override
            int read() throws IOException {
                return 0
            }
        }*/
        //java.lang.Object inputStream = new Object()
       // BeanUtilsBean but = new BeanUtilsBean()
       // BeanUtils.copyProperties(inputStream,JKSStream)
        //BeanUtilsBean2.copyProperties(inputStream,JKSStream)
      //  BeanUtils.copyProperties(inputStream, JKSStream)
       // copyProperty(inputStream, JKSStream)
/*        InputStream inputStream =CloneUtil.clone(JKSStream, -1)*/
 /*       BeanUtils.copyProperties(inputStream, JKSStream)*/
        InputStream inputStream = JKSStreamCache.getInputStream()
        return  inputStream
    }

    static String getAppId () {
        return HWPush.appId.trim()
    }

    static String getAppSecret () {
        return HWPush.appSecret.trim()
    }

    static int getMinConnection () {
        return Integer.parseInt(HWPush.minConnection.trim())
    }

    static int getMaxConnection () {
        return Integer.parseInt(HWPush.maxConnection.trim())
    }

    static int getTokenFresh () {
        return  Integer.parseInt(HWPush.tokenFresh.trim())
    }


}
