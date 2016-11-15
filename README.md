# rishiqing-push-java
日事清推送程序

版本
-----
V 1.0.0



下载
-----
默认只提供groovy 2.0.8和2.4.7的版本，如果需要其它版本，可以自行打包
https://github.com/solaxxx/rishiqing-push-java/tree/master/target



简介
-----
* 服务端推送工具，可同时对多种类型推送进行发送

* 目前支持的推送：

| 类型        | 备注     |
| ------------- | ------------- |
| 小米推送 | 推荐 |
| 极光推送 | 推荐 |
| 阿里推送 |  |
| 华为推送 |  |
| webSocket推送 | 推荐 |


准备工作
-----
* 将下载后的jar包中的push目录中的配置文件内容补全，放入工程的配置文件夹下即可



使用示例
-----
* 给一个指定用户发送消息
<pre><code>
    def push = PushCenter.createFactory()                            //  获得推送实例
    push.addAndroidPush(PushCenter.MI_PUSH)                          //  使用小米推送
    PushBean pushBean = new PushBean('标题', "描述")                  //  构建推送对象
    pushBean.targetValue = '282'                                     //  设置alias
    pushBean.addExtra('sss','sss')                                   //  自定义字段  
    pushBean.addExtra('ddd','ddd')                                   //  自定义字段  
    push.notice.push(pushBean)                                       //  发送通知栏消息
</code></pre>

* 给所有用户发送消息
<pre><code>
    def push = PushCenter.createFactory()                             //  获得推送实例
    push.addAndroidPush(PushCenter.MI_PUSH)                           //  使用小米推送
    PushBean pushBean = new PushBean('标题', "描述")         
    pushBean.target ='all'                                            //  给所有设备
    push.notice.push(pushBean)                                        //  发送通知栏消息
</code></pre>

* 同时使用 “小米推送” 和 “极光推送” 
<pre><code>
    def push = PushCenter.createFactory()                             //  获得推送实例
    push.addAndroidPush(PushCenter.MI_PUSH)                           //  使用小米推送
    push.addAndroidPush(PushCenter.J_PUSH)                            //  使用极光推送
    PushBean pushBean = new PushBean('标题', "描述")         
    pushBean.target ='all'                                            //  给所有设备
    push.notice.push(pushBean)                                        //  发送通知栏消息
</code></pre>

* 使用 webSocket推送
<pre><code>
    def webPush = PushCenter.createFactory(PushCenter.WEB)            // 获得推送实例
    webPush.webPush('roomId1', [pTitle:'标题', id:'95631', clock:'23:59']) // 推送
</code></pre>

方法详细说明
-----
* PushCenter静态方法

| name          | method        |remark |
| ------------- |:-------------:| ------- |
| PushCenter    | createFactory(String type) |PushCenter.PHONE 移动端推送, PushCenter.WEB weSocket推送。默认是移动端
||setConfigRootPath(String path) 设置配置文件根目录路径，默认:'push'||



* PushCenter.createFactory()对象方法

生成推送对象：
def push = PushCenter.createFactory(PushCenter.PHONE)

| name          | method        |remark |params |
| ------------- |:-------------:| ------- | ------- |
|push|addAndroidPush(String pushType)|设置Android推送类型|PushCenter.MI_PUSH 小米|
||||PushCenter.J_PUSH极光推送|
||||PushCenter.ALI_PUSH阿里推送|
||||PushCenter.J_PUSH华为推送|
|push|addIosPush(String pushType)|设置iOS推送类型|PushCenter.MI_PUSH 小米|
||||PushCenter.J_PUSH极光推送|
||||PushCenter.ALI_PUSH阿里推送|
||||PushCenter.J_PUSH华为推送|
|push|.notice.push()|发送通知栏消息|PushBean|
|push|.message.push()|发送透传消息|PushBean|


* PushBean 对象方法

| name          | method        |remark |
| ------------- |:-------------:| ------- |
| pushBean      | setTitle(String title)      |设置标题|
|               | setDescription(String description)      |设置描述|
|               | setTarget(String target)      |设置目标类型  PushBean.TARGET_ALL , PushBean.TARGET_ALIAS(默认) |
|               | setTargetValue(Object object)     | 设置目标alias，可以是字符串也可以是list  例：‘1,2,3’ 或 list a = [] |
|               | addExtra(String key, String value)      | 自定义参数，例：pushBean.addExtra('key','value')|




打包方式
-----
* 打包：mvn clean package

打包其他groovy版本
-----
* 修改pom.xml中配置

<pre><code>
   "<groovy.version>2.3.8</groovy.version>" // 修改为任意版本号
</code></pre>


*  运行打包命令 mvn clean package
*  jar包生成在/target/2.3.8/下
*  rishiqing-push-java-1.0.jar 不包含依赖包
*  rishiqing-push-java-1.0-jar-with-dependencies.jar 包含依赖包


备注
-----
暂无

