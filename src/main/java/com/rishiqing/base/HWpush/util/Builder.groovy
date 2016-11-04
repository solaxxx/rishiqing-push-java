package com.rishiqing.base.HWpush.util

import com.alibaba.fastjson.JSONObject
import com.rishiqing.base.push.PushBean
import com.rishiqing.utils.PushCommonUtil

/**
 * Created by solax on 2016/11/2.
 */
class Builder {

/*      hashMap.put("push_type", push_type);
        hashMap.put("tokens", tokens);
        hashMap.put("tags", tags);
        hashMap.put("exclude_tags", exclude_tags);
        hashMap.put("android", android);
        hashMap.put("send_time", send_time);
        hashMap.put("expire_time", expire_time);*/
    static def getMessage (PushBean pushBean) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (pushBean.target == PushBean.TARGET_ALL) {
            resultMap.push_type = 2
        } else {
            resultMap.push_type = 3
            resultMap.tags  = getTag(pushBean)
        }
        resultMap.android = this.getBody(pushBean)
        // println(PushCommonUtil.mapToJson(resultMap))
        return resultMap
    }

    private static def getExtras (PushBean pushBean) {
        def result = []
        if (pushBean.extra) {
            pushBean.extra.each{ key, value ->
                def temp = [:]
                temp[key] = value
                result.add(temp)
            }
        }
     //   def jsonString  =  JSONObject.toJSONString(result)
     //   println('huawei getExtras = ' +   jsonString);
        return result
    }

    private static def getBody (PushBean pushBean) {
       /* {\"notification_title\":\"the good news!\",\"notification_content\":\"Price reduction!\",\"doings\":3,\"url\":\"vmall.com\"}*/
        def result = [:]
        result.notification_title = pushBean.title
        result.notification_content = pushBean.description
        result.doings = 1
        result.extras = this.getExtras(pushBean);
        //def jsonString  = PushCommonUtil.mapToJson(result)
        //println('huawei body = ' + jsonString);
        return result
    }


    private static def getTag (PushBean pushBean) {
        if (!pushBean.targetValue) return null
        def result = [:], mapList = []
        mapList.add(['uid' : pushBean.targetValue])
        result.tags = mapList
      //  def jsonString  =  JSONObject.toJSONString(result)
       // println('huawei tag = ' + jsonString);
        return result
    }
}
