# rishiqing-push-java
日事清推送程序

版本
-----
V 1.0.0

简介
-----
* 推送系统融合了 ”阿里推送” 和 “小米推送”。

* 无论是android 还是 ios，以小米推送做为主推送。

* 使用阿里推送主要是因为阿里推送中有完整版的华为推送以及阿里原生推送。华为推送可以保证消息对于华为手机的送达率以及增加了app唤醒的可能性。

* Andorid 推送类型选择：
    def push = PushCenter.createFactory(PushCenter.HUAWEI) 构建推送对象时，只需要选择是使用 “华为推送” 或者 “ 小米推送即可”
    参数：
    PushCenter.HUAWEI 华为
    PushCenter.MI 小米
    NULL : 小米

* Ios推送默认进行小米推送，无法修改。

* 调用一次发送会给android 和 ios 端同时发送。

* 以后会加入更多推送方式，以及更加自由的模式切换。

使用示例
-----
* 给一个指定用户发送消息
<pre><code>
    def push = PushCenter.createFactory(PushCenter.HUAWEI)            // android 端使用阿里推送，ios端默认使用小米推送，无法修改
    PushBean pushBean = new PushBean('标题', "描述", '123')           //  给 alias为123 的用户发送一条提醒
    pushBean.addExtra('sss','sss')                                   //  自定义字段  
    pushBean.addExtra('ddd','ddd')                                   //  自定义字段  
    push.notice.push(pushBean)                                       //  发送
</code></pre>

* 给所以用户发送消息
<pre><code>
    def push = PushCenter.createFactory(PushCenter.HUAWEI)            // android 端使用阿里推送，ios端默认使用小米推送，无法修改
    PushBean pushBean = new PushBean('标题', "描述")         
    pushBean.target ='all'                                            //  给 所有设备发送一条提醒
    push.notice.push(pushBean)                                        //  发送
</code></pre>

方法详细说明
-----
* 对象

| name          | method        |remark |
| ------------- |:-------------:| ------- |
| PushCenter    | createFactory(String type) |PushCenter.HUAWEI 华为, PushCenter.MI 小米。默认是小米
| pushBean      | setTitle(String title)      |设置标题|
|               | setDescription(String description)      |设置描述|
|               | setTarget(String target)      |设置目标类型  PushBean.TARGET_ALL , PushBean.TARGET_ALIAS(默认) |
|               | setTargetValue(Object object)     | 设置目标alias，可以是字符串也可以是list  例：‘1,2,3’ 或 list a = [] |
|               | addExtra(String key, String value)      | 自定义参数，例：pushBean.addExtra('key','value')|

* PushCenter对象方法

生成推送对象：
def push = PushCenter.createFactory(PushCenter.HUAWEI)

| method        | remark     |
| ------------- | ------------- |
| push.notice.push(PushBean pushBean)  | 发送提醒 |
| push.message.push(PushBean pushBean)       | 发送消息,消息是静默的  |


打包方式
-----
* 打包：mvn package
* 打包并跳过测试：mvn package -Dmaven.test.skip=true
* 注：打包目前不够完善，需要手动把打包后jar包中的MiPush_SDK_Server_2_2_17.jar > xiaomi包拷贝到com目录中

备注
-----
暂无

