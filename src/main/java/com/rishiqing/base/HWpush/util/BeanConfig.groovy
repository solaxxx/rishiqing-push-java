package com.rishiqing.base.HWpush.util

import com.rishiqing.base.push.PushBean

/**
 * Created by Administrator on 2016/11/2.
 */
class BeanConfig {
    static def getHuaweiPushBean (PushBean body) {
        // 过滤目标，如果是list ,则不过滤，如果是数组则过滤处理为list
        if (body.targetValue instanceof String ) {
            def targetValue = []
            String [] args = body.targetValue.split(',')
            if (args.length > 1) {
                body.targetValue.each{ it ->
                    targetValue.add(it)
                }
            } else {
                targetValue.add(args[0])
            }
            body.targetValue = targetValue
        }
        return body
    }
}
