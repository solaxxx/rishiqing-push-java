package com.rishiqing.base.mipush

import com.rishiqing.base.push.AbstractPush

/**
 * Created by solax on 2016/8/22.
 *
 * 小米推送入口点
 */
class MiPush extends AbstractPush{
    MiPush () {
        println('MiPush 1')
        setMessage(new  Message ())
        println('MiPush 2')
        setNotice(new  Notice ())
        println('MiPush 3')
    }
}
