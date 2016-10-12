package com.rishiqing.base.push

/**
 * Created by solax on 2016/8/22.
 */
interface IMessage {

    public   void pushAndroid (PushBean body)

    public   void pushAndroid (PushBean body, Map params)

    public   void pushIos (PushBean body)

    public   void pushIos (PushBean body, Map params)
}
