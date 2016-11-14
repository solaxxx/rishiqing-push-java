package com.rishiqing.base.HWpush.util

import nsp.OAuth2Client
import nsp.support.common.AccessToken

/**
 * Created by solax on 2016/11/3.
 */
public class HWToken {
    private static  AccessToken token

    private static Date date

    private HWToken() {}

    public static AccessToken getInstance () {
        if (isTokenFresh()) {
            token = freshToken()
        }
        return token
    }

    private static  def isTokenFresh () {
        if (date) {
            def systemDate = new Date ()
            def date1 = systemDate.plus( - HWPushConfig.getTokenFresh() ).clearTime()
            if (date1.after(date)) {
                date = systemDate
                return true
            }
            return  false
        } else if (!date) {
            date = new Date ()
            return true
        }
    }

    /**
     * 刷新token
     */
    private static def freshToken () {
        OAuth2Client oauth2Client = new OAuth2Client();
        oauth2Client.initKeyStoreStream(HWPushConfig.getCloneStream(), HWPushConfig.getOauth2Password());
        AccessToken access_token = oauth2Client.getAccessToken("client_credentials", HWPushConfig.getAppId(), HWPushConfig.getAppSecret());
        System.out.println("HUAWEI access token :" + access_token.getAccess_token() + ",expires time[access token 过期时间]:" + access_token.getExpires_in());
        return access_token
    }
}
