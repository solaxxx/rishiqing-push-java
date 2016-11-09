package com.rishiqing.base.HWpush.util

/**
 * Created by solax on 2016/11/9.
 */
interface IHuawei {

    /**
     * 获取用户标签列表
     * @return
     */
    public String getUserTag ()

    /**
     * 设置用户标签
     * @return
     */
    public String setUserTag (String token, String tag, String value)

    /**
     * 删除用户标签
     * @return
     */
    public String  removeUserTag (String token, String tag)
}
