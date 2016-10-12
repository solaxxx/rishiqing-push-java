package com.rishiqing

import org.junit.Test
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Administrator on 2016/9/22.
 */
class TestPushCenter {

    @Test
    public void testPushCenter () {
        def push = PushCenter.createFactory(PushCenter.HUAWEI)
        def pushMap = [:]
        pushMap.targetValue = 'all'
        pushMap.title = '我的测试title'
        pushMap.body = '这是body'+ Math.random()
        push.message.push(pushMap)
        // assertEquals(h.sayHello("jizg"),"hello :jizg");
    }
}
