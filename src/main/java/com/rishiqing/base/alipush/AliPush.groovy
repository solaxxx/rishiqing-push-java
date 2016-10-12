package com.rishiqing.base.alipush

import com.rishiqing.base.push.AbstractPush

/**
 * Created by solax on 2016/8/22.
 */
class AliPush extends AbstractPush{
    AliPush () {
        println('AliPush 1')
        setMessage(new  Message ())
        println('AliPush 2')
        setNotice(new  Notice ())
        println('AliPush 3')
    }
}
