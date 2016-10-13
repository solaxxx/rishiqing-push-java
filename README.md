# rishiqing-push-java
日事清推送程序

打包方式
-----
* 打包：mvn package
* 打包并跳过测试：mvn package -Dmaven.test.skip=true
* 注：打包目前不够完善，需要手动把打包后jar包中的MiPush_SDK_Server_2_2_17.jar > xiaomi包拷贝到com目录中

使用示例
-----
* 给一个指定用户发送消息
def push = PushCenter.createFactory(PushCenter.HUAWEI)            // android 端使用华为推送，ios端默认使用小米推送，无法修改
PushBean pushBean = new PushBean('我的测试xiaomi', "sss", '123')  //  给 alias为123 的用户发送一条消息
pushBean.addExtra('sss','sss')                                   //  自定义字段  
pushBean.addExtra('ddd','ddd')                                   //  自定义字段  
push.notice.push(pushBean)                                       //  发送

方法详细说明
-----

