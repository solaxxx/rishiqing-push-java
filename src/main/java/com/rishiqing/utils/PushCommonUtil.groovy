package com.rishiqing.utils

import groovy.json.JsonBuilder
import net.sf.json.JSONObject
import org.json.simple.JSONArray

import java.security.MessageDigest

/**
 * Created by solax on 2016/10/24.
 */
class PushCommonUtil {
    static String mapToJson (Map map) {
        JSONObject jo = JSONObject.fromObject(map)
        return jo.toString()
    }

    static String listToJson (List list) {
        String jo = JSONArray.toJSONString(list)
        return jo
    }
    static String stringToMD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
