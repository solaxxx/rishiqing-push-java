package com.rishiqing.base.jpush
import com.rishiqing.base.push.AbstractPush
/**
 * Created by solax on 2016/10/24.
 */
class JPush  extends AbstractPush {

    JPush () {
        setMessage(new  Message ())
        setNotice(new  Notice ())
    }
}
