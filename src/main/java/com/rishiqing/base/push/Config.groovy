package com.rishiqing.base.push

/**
 * Created by solax on 2016/8/24.
 */
class Config {



    private  static Properties initializeConfig (def key) {
        boolean result = false;
        try {
            Properties config= new Properties();
            InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream(key)
            config .load(is);
            return config
            //this.url = prop.getProperty("betaSocketIoUrl").trim() +  prop.getProperty("betaSocketIoRouter").trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
