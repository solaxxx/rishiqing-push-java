package com.rishiqing.base.push

import com.rishiqing.utils.ThreadPool

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 * Created by solax on 2016/8/26.
 */
class ProxyHandle implements InvocationHandler{
    private Object obj = null;

    @Override
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("im invoke");
        def self = this
        ThreadPool.executeTread(new Runnable(){
            @Override
            public void run() {
                try{
                   method.invoke(self.obj, args);
                }catch (Exception e){}
            }
        })
        return self.obj;
    }
}
