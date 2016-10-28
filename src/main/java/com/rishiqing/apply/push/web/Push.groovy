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

    def void webPush (String roomId, String type, Map map) {
        def p = [
                type: type,
                body : map
        ]
        this.pushTo(roomId, p)
    }

    def void webPush (String roomId, Map map) {
        this.pushTo(roomId, map)
    }

    private void pushTo (String roomId, Map map) {
        this.threadUtil.executeTread(new Runnable(){
            @Override
            public void run() {
                try{  webPush.push(roomId, map)}catch (Exception e){ e.printStackTrace() }
            }
        })
    }
}
