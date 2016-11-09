package com.rishiqing.base.HWpush.util

import nsp.NSPClient
import nsp.support.common.AccessToken

/**
 * Created by Administrator on 2016/11/9.
 */
class HWClient {
    /**
     * 建立client连接
     * @param access_token
     * @return
     */
    public static NSPClient createClient (AccessToken access_token) {
        NSPClient client = new NSPClient(access_token.getAccess_token());
        client.initHttpConnections(HWPushConfig.getMinConnection(), HWPushConfig.getMaxConnection());//设置每个路由的连接数和最大连接数
        client.initKeyStoreStream(HWPushConfig.getCloneStream(), HWPushConfig.getOauth2Password());
        //设置http超时时间
        client.setTimeout(10000, 15000);
        return client
    }
}
