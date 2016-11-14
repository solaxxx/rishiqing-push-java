package com.rishiqing.base.HWpush

import com.rishiqing.base.HWpush.util.HWClient
import com.rishiqing.base.HWpush.util.HWToken
import com.rishiqing.base.HWpush.util.IHuawei
import com.rishiqing.base.push.AbstractPush
import nsp.NSPClient
import nsp.support.common.AccessToken

/**
 * Created by solax on 2016/11/2.
 */
class HWPush extends AbstractPush implements IHuawei{
    HWPush () {
        setMessage(new  Notice ())
        setNotice(new  Notice ())
    }

    def getUserTag() {
        //  获取token
        AccessToken access_token = HWToken.getInstance()
        //接口调用
        NSPClient client = HWClient.createClient(access_token)
        //接口调用
        String rsp = client.call("openpush.openapi.query_app_tags", [:], String.class);

        // println('getUserTag:' + rsp)

        return rsp
    }

    def setUserTag(String token, String tag, String value) {
        //  获取token
        AccessToken access_token = HWToken.getInstance()
        //接口调用
        NSPClient client = HWClient.createClient(access_token)
        //接口调用
        def map =[:]
        map.token     =  token
        map.tag_key   =  tag
        map.tag_value =  value
        String rsp = client.call("openpush.openapi.set_user_tag", map, String.class);

        // println('set_user_tag: ' + rsp)

        return rsp
    }

    def removeUserTag(String token, String tag) {
        //  获取token
        AccessToken access_token = HWToken.getInstance()
        //接口调用
        NSPClient client = HWClient.createClient(access_token)
        //接口调用
        def map =[:]
        map.token   =   token
        map.tag_key =   tag
        String rsp = client.call("openpush.openapi.delete_user_tag", map, String.class);

        // println('removeUserTag: ' + rsp)

        return rsp
    }
}
