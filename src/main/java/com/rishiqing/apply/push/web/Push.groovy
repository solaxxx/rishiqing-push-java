package com.rishiqing.apply.push.web

import com.rishiqing.apply.base.AbstractApplyPush
import com.rishiqing.base.webpush.WebPush
import com.rishiqing.utils.ThreadUtil

/**
 * Created by solax on 2016/10/26.
 */
class Push  extends AbstractApplyPush{
    private  WebPush  webPush

    Push (WebPush webPush) {
        this.webPush = webPush
    }
    def void webPush (String roomId, Map map) {
        ThreadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{  this.webPush.push(roomId, map)}catch (Exception e){ e.printStackTrace() }
            }
        })
    }
}
