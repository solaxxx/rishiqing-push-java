package com.rishiqing.base.mipush

import com.rishiqing.base.push.AbstractPush

/**
 * Created by solax on 2016/8/22.
 *
 * 小米推送入口点
 */
class MiPush extends AbstractPush{
    MiPush () {
        setMessage(new  Message ())
        setNotice(new  Notice ())
    }
}
