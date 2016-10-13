package com.rishiqing

import com.rishiqing.apply.push.Push
import com.rishiqing.apply.base.AbstractApplyPush
import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.alipush.AliPush
import com.rishiqing.base.mipush.MiPush
import com.rishiqing.base.push.PushBean

/**
 * Created by solax on 2016/8/22.
 *
 * 推送中心入口
 *
 * 会通过标识符确认推送的类型，默认以小米推送为主
 *
 */

class PushCenter {

    public  final static  String HUAWEI = 'huawei'

    public final static  String MI     = 'mi'

    private final static AbstractPush miPush = new MiPush()

    private final static AbstractPush aliPush = new AliPush()

    public static AbstractApplyPush createFactory (def model) {
        Push push = new Push ();
        switch (model){
            case HUAWEI :
                push.setPush(aliPush, miPush)
                break
            case MI:
                push.setPush(miPush, miPush)
                break
            default:
                push.setPush(miPush, miPush)
        }
        return push
    }
    public static void main (String  [] args) {
        def push = PushCenter.createFactory(PushCenter.HUAWEI)
        def list = []
        list.add('13916')
        PushBean pushBean = new PushBean('我的测试xiaomi', "sss")
        pushBean.target ='all'
        pushBean.addExtra('sss','sss')
        pushBean.addExtra('ddd','ddd')
        push.notice.push(pushBean)
    }
}
