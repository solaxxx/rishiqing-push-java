package com.rishiqing.base.HWpush

import com.rishiqing.base.push.AbstractPush

/**
 * Created by solax on 2016/11/2.
 */
class HWPush extends AbstractPush{
    HWPush () {
        setMessage(new  Notice ())
        setNotice(new  Notice ())
    }
}
