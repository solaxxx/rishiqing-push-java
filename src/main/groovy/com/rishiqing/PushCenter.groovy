package com.rishiqing

import com.rishiqing.apply.push.phone.Push
import com.rishiqing.apply.base.AbstractApplyPush
import com.rishiqing.base.HWpush.HWPush
import com.rishiqing.base.HWpush.util.IHuawei
import com.rishiqing.base.jpush.JPush
import com.rishiqing.base.push.AbstractPush
import com.rishiqing.base.alipush.AliPush
import com.rishiqing.base.mipush.MiPush
import com.rishiqing.base.push.PushBean
import com.rishiqing.base.webpush.WebPush
import com.rishiqing.utils.ThreadPool
import com.xiaomi.xmpush.server.Constants

import java.util.concurrent.ThreadPoolExecutor

/**
 * Created by solax on 2016/8/22.
 *
 * 推送中心入口
 *
 * 会通过标识符确认推送的类型，默认以小米推送为主
 *
 */

class PushCenter {

    private  static configRootPath = 'push'

/*    public  final static  String HUAWEI = 'huawei'

    public final static  String MI     = 'mi'

    public final static  String JPUSH     = 'jPush'*/

    public final static String WEB = 'web'

    public final static String PHONE = 'phone'

    // web 推送
    public final static AbstractPush WEB_PUSH = new WebPush()

    // 小米推送
    public final static AbstractPush MI_PUSH = new MiPush()

    // 阿里推送
    public final static AbstractPush ALI_PUSH = new AliPush()

    // 极光推送
    public  final static AbstractPush J_PUSH   = new JPush()

    // 华为推送
    public  final static AbstractPush HW_PUSH   = new HWPush()
    /**
     * 进行移动端推送
     * @return
     */
    public static AbstractApplyPush createFactory () {
        return PushCenter.createFactory(PushCenter.PHONE, null)
    }
    /**
     * 获得推送对象
     * @param type
     * @return
     */
    public static AbstractApplyPush createFactory (String type) {
        return PushCenter.createFactory(type, null)
    }

    /**
     * 获得移动端推送对象并设置线程池
     * @param threadPoolExecutor
     * @return
     */
    public static AbstractApplyPush createFactory (ThreadPoolExecutor threadPoolExecutor) {
        return PushCenter.createFactory(PushCenter.PHONE, threadPoolExecutor)
    }

    /**
     * 设置类型并设置线程池
     * @param type
     * @param threadPoolExecutor
     * @return
     */
    public static  AbstractApplyPush createFactory (String type , ThreadPoolExecutor threadPoolExecutor) {
        AbstractApplyPush push
        switch (type) {
            case  WEB :
                push = new com.rishiqing.apply.push.web.Push(WEB_PUSH)
                push.setThreadUtil(threadPoolExecutor)
                break;
            case  PHONE :
                push =  new Push()
                push.setThreadUtil(threadPoolExecutor)
                break;
            default:
                break;
        }
        return push
    }

    public static HWPush getHWPush () {
        return HW_PUSH
    }

    public static void main (String  [] args) {
        // 设置推送配置文件目录
       // PushCenter.setConfigRootPath('push')
       // 获取推送对象
        def push = PushCenter.createFactory()
        // 设置推送类型
       // push.addAndroidPush(PushCenter.MI_PUSH)
       push.addIosPush(PushCenter.MI_PUSH)
       // push.addAndroidPush(PushCenter.J_PUSH)
       // push.addAndroidPush(PushCenter.ALI_PUSH)
        //push.addIosPush(PushCenter.J_PUSH)
        //push.addIosPush(PushCenter.MI_PUSH)
      //push.addAndroidPush(PushCenter.HW_PUSH)

        // 设置推送内容
        PushBean pushBean = new PushBean('透传', "透传2")
        pushBean.targetValue = '582'//'282'
        //pushBean.soundURL = 'pushsound'
        // pushBean.target ='all'
        pushBean.addExtra('sss',11)
        pushBean.addExtra('ddd',22)
        pushBean.addExtra('ddd',22)
        // 推送提醒
        push.message.push(pushBean)
            // web端推送
/*
       def webPush = PushCenter.createFactory(PushCenter.WEB)
        def list = []
        list.add('userId91')
       webPush.webPush('userId92,293923,123123', [pTitle:'斯蒂芬斯蒂芬斯蒂芬斯蒂芬斯蒂芬斯蒂芬撒旦法撒旦发射电风扇地方斯蒂芬是', id:'95631', clock:'23:59'])
*/

        //HWPush hwPush = PushCenter.getHWPush()
        //hwPush.getUserTag()
        //hwPush.setUserTag('_d9c158cd141242b200000147100CN01', 'uId', '5')
        //hwPush.removeUserTag('_d9c158cd141242b200000147100CN01', 'uId')
    }

    public static void setConfigRootPath (String path) {
        configRootPath = path
    }

    public static String getConfigRootPath () {
        return configRootPath
    }
}
