package com.rishiqing.base.HWpush.util

import com.alibaba.fastjson.JSONObject
import com.rishiqing.PushCenter
import nsp.NSPClient
import nsp.OAuth2Client
import nsp.support.common.AccessToken

/**
 * Created by solax on 2016/11/2.
 */
class Sender {

    static def send (HashMap<String, Object> body) {

        //  获取token
        AccessToken access_token = HWToken.getInstance()
        //接口调用
        NSPClient client = HWClient.createClient(access_token)
        String rsp = client.call("openpush.openapi.notification_send", body, String.class);
        printStack(rsp);
    }

    static def printStack (String rsq) {
        JSONObject jsonObject = JSONObject.parse(rsq)
        if (jsonObject.get('result_code') != 0) {
            println('HUAWEI PUSH ERROR : id_' + jsonObject.get('request_id') +', ' + jsonObject.get('result_desc'))
        }
    }

    static def getUserTag () {
        //  获取token
        AccessToken access_token = HWToken.getInstance()
        //接口调用
        NSPClient client = HWClient.createClient(access_token)
        //接口调用
        String rsp = client.call("openpush.openapi.query_app_tags", [:], String.class);
        println(rsp)
    }

    static def setUserTag () {
        //  获取token
        AccessToken access_token = HWToken.getInstance()
        //接口调用
        NSPClient client = HWClient.createClient(access_token)
        //接口调用
        def map =[:]
        map.token ='_d9c158cd141242b200000147100CN01'
        map.tag_key ='uId'
        map.tag_value ='6'
        String rsp = client.call("openpush.openapi.set_user_tag", map, String.class);
        println(rsp)
    }

    static def removeUserTag () {
        //  获取token
        AccessToken access_token = HWToken.getInstance()
        //接口调用
        NSPClient client = HWClient.createClient(access_token)
        //接口调用
        def map =[:]
        map.token ='_d9c158cd141242b200000147100CN01'
        map.tag_key ='uId'
        String rsp = client.call("openpush.openapi.delete_user_tag", map, String.class);
        println(rsp)
    }

    public static void main(String [] args) {
        // 设置推送配置文件目录
        PushCenter.setConfigRootPath('push')
 setUserTag()
    //removeUserTag()
 // getUserTag()
    }
}
