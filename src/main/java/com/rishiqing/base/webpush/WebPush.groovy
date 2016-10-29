package com.rishiqing.base.webpush

import com.rishiqing.PushCenter
import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.webpush.util.WebPushConfig
import com.rishiqing.utils.PushCommonUtil
import groovyx.net.http.AsyncHTTPBuilder
import groovyx.net.http.ContentType
import groovyx.net.http.EncoderRegistry
import groovyx.net.http.HTTPBuilder

import java.util.concurrent.Executors

import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

/**
 * Created by solax on 2016/10/26.
 */
class WebPush extends AbstractPush{
    def void push (String roomId, Map map) {
        String url = WebPushConfig.getWebSocketUrl()
        def http = new HTTPBuilder(url)
        try {
            http.encoderRegistry = new EncoderRegistry( charset:'utf-8' )
            http.request( POST, JSON ) { req ->
/*                uri.path = WebPushConfig.getRouter()*/
                body = generateParams(roomId, map)
                requestContentType = URLENC
                response.success= {resp, reader->
                    if (!reader.success) {
                        println('webPush failed :' + reader.message)
                    }
                }
                response.failure={
                    println('webPush failed : status: ' +  resp.status + ', maybe connect error')
                }
            }
        } catch (Exception e) {
            println('webPush failed : Exception catch -- ' + e.message)
        }
    }
    def generateParams (String roomId,Map body) {
        def params = [:]
        params.authCode = WebPushConfig.getAuthCode()
        params.notification = PushCommonUtil.mapToJson(body)
        params.audience = [
            roomId : roomId
        ]
        def json  = PushCommonUtil.mapToJson(params) ;
        return json
    }
}
