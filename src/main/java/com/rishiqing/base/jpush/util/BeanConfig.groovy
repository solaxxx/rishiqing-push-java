package com.rishiqing.base.jpush.util

import com.rishiqing.base.push.PushBean

/**
 * Created by solax on 2016/10/24.
 */
class BeanConfig {
    static def getJPushPushBean (PushBean body) {
        if (body.targetValue instanceof  List) {
            String targetValue = '';
            int index = 1;
            body.targetValue.each{ it ->
                if (index != body.targetValue.size()) {
                    targetValue += it + ','
                } else {
                    targetValue += it
                }
                index ++
            }
            body.targetValue = targetValue
        }
        return  body
    }
}
