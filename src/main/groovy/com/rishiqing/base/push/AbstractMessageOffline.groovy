package com.rishiqing.base.push

/**
 * Created by solax on 2016/8/22.
 */
abstract class AbstractMessageOffline {
    private IMessage message

    AbstractMessageOffline () {}

    AbstractMessageOffline (def message) {
        this.message = message
    }

    public abstract  void pushAndroid (def body)

    public abstract  void pushAndroid (def body, Map params)

    public abstract  void pushIos (def body)

    public abstract  void pushIos (def body, Map params)
}
