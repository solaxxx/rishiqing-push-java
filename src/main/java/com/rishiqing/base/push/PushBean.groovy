package com.rishiqing.base.push

import com.rishiqing.base.mipush.util.MiPushConfig

/**
 * Created by solax on 2016/10/11.
 *
 * 传入参数的规范类
 *
 */
class PushBean implements Cloneable{

    public static TARGET_ALL   =  'all'

    public static TARGET_ALIAS =  'alias'

    private static int TITLE_LENGTH =  20

    public int deviceRecord = 0 // 0 android  1 ios

    /**
     * 公共参数
     */
    private String  title                           // 标题

    private String  description = '日事清来了'    // 详细描述

    private String  target                          // all、alias

    private Object  targetValue                    // 发送的目标设备 alias

    private def     extra = [:]                     // 自定义参数map

    private String  badge       =  '1'              // 角标显示的数字

    // advance params, custom config
    private String appSecret

    /**
     * 阿里云参数
     */
    private String  aliTarget   =  'account'

    private int    deviceType  =  0                  // 设备类型deviceType 取值范围为:0~3. iOS设备: 0; Android设备: 1; 全部: 3,

    private int    aliType     =  1

    /**
     * miPush参数
     */
    private String messagePayload

    private int    passThrough = 0                  // 1表示透传消息，0表示通知栏消息。

    private int    notifyType  = 1                   // 提示音类型

    private long   timeToLive  = Long.parseLong(MiPushConfig.getTimeToLive()) // 离线保存时间，默认不离线保存

    private  String  soundURL   = "default"

    private  String  category   = "action"

    private  boolean rePush    = false;

    private  String   regId

    private  String   alias

    PushBean(String title, String description) {
        this.setTitle(title)
        this.setDescription(description)
    }

    PushBean(String title, String description, String targetValue) {
        this.setTitle(title)
        this.setDescription(description)
        this.targetValue = targetValue
    }

    PushBean(String title, String description, List targetValue) {
        this.setTitle(title)
        this.setDescription(description)
        this.targetValue = targetValue
    }

    PushBean(String title, String description, Object targetValue, extra) {
        this.setTitle(title)
        this.setDescription(description)
        this.targetValue = targetValue
        this.extra = extra
    }

    PushBean(String title, String description, String target, Object targetValue, extra) {
        this.setTitle(title)
        this.setDescription(description)
        this.target = target
        this.targetValue = targetValue
        this.addExtra(extra)
    }

    int getDeviceRecord() {
        return deviceRecord
    }

    void setDeviceRecord(int deviceRecord) {
        this.deviceRecord = deviceRecord
    }

    String getTitle() {
        return title
    }

    void setTitle(String title) {
        if (!title) {
            this.title = 'title'
            return
        }
        if (title.length() > TITLE_LENGTH) {
            this.title = title.substring(0,17) + '...'
            return
        }
        this.title = title
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        // this.description = description
        this.description = '知识工作者的瑞士军刀'
    }

    String getTarget() {
        return target
    }

    void setTarget(String target) {
        this.target = target
    }



    void setTarget(Long target) {
        this.target = String.valueOf(target)
    }

    Object getTargetValue() {
        return targetValue
    }

    void setTargetValue(def targetValue) {
        if (targetValue instanceof  List) {
            this.targetValue = targetValue
        } else {
            this.targetValue = String.valueOf(targetValue)
        }
    }

    def getExtra() {
        return extra
    }

    void setExtra(extra) {
        this.extra = extra
    }

    String getBadge() {
        return badge
    }

    void setBadge(String badge) {
        this.badge = badge
    }

    String getAliTarget() {
        return aliTarget
    }

    void setAliTarget(String aliTarget) {
        this.aliTarget = aliTarget
    }

    int getDeviceType() {
        return deviceType
    }

    void setDeviceType(int deviceType) {
        this.deviceType = deviceType
    }

    String getMessagePayload() {
        return messagePayload
    }

    void setMessagePayload(String messagePayload) {
        this.messagePayload = messagePayload
    }

    int getPassThrough() {
        return passThrough
    }

    void setPassThrough(int passThrough) {
        this.passThrough = passThrough
    }

    int getNotifyType() {
        return notifyType
    }

    void setNotifyType(int notifyType) {
        this.notifyType = notifyType
    }

    long getTimeToLive() {
        return timeToLive
    }

    void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive
    }

    String getSoundURL() {
        return soundURL
    }

    void setSoundURL(String soundURL) {
        this.soundURL = soundURL
    }

    String getCategory() {
        return category
    }

    void setCategory(String category) {
        this.category = category
    }

    String getAppSecret() {
        return appSecret
    }

    void setAppSecret(String appSecret) {
        this.appSecret = appSecret
    }

    boolean getRePush() {
        return rePush
    }

    void setRePush(boolean rePush) {
        this.rePush = rePush
    }

    String getRegId() {
        return regId
    }

    void setRegId(String regId) {
        this.regId = regId
    }

    String getAlias() {
        return alias
    }

    void setAlias(String alias) {
        this.alias = alias
    }

    void addExtra (String key, String value) {
        this.extra[key] = value
    }

    void addExtra (String key, int value) {
        this.extra[key] = String.valueOf(value)
    }

    void addExtra (String key, Integer value) {
        this.extra[key] = String.valueOf(value)
    }

    void addExtra (String key, long value) {
        this.extra[key] = String.valueOf(value)
    }

    void addExtra (String key, Long value) {
        this.extra[key] = String.valueOf(value)
    }

    int getAliType() {
        return aliType
    }

    void setAliType(int aliType) {
        this.aliType = aliType
    }

}
