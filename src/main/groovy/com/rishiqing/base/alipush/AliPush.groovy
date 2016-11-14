package com.rishiqing.base.alipush

import com.rishiqing.base.push.AbstractPush

/**
 * Created by solax on 2016/8/22.
 */
class AliPush extends AbstractPush{
    AliPush () {
        setMessage(new  Message ())
        setNotice(new  Notice ())
    }
}
