package com.rishiqing.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by Administrator on 2016/11/4.
 */
class HtmlScript {
    public static String delHTMLTag(String htmlStr){
        try {
            if (!htmlStr) return "";
            String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
            String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
            String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

            Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
            Matcher m_script=p_script.matcher(htmlStr);
            htmlStr=m_script.replaceAll(""); //过滤script标签

            Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
            Matcher m_style=p_style.matcher(htmlStr);
            htmlStr=m_style.replaceAll(""); //过滤style标签

            Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
            Matcher m_html=p_html.matcher(htmlStr);
            htmlStr=m_html.replaceAll(""); //过滤html标签
            return htmlStr.trim(); //返回文本字符串
        } catch (Exception e) {
            println('script html :' + e.message)
            return htmlStr
        }
    }

    /**
     *去掉字符串里面的html代码。<br>
     *要求数据要规范，比如大于小于号要配套,否则会被集体误杀。
     *　
    *@paramcontent
     *　　　　　内容
     *@return去掉后的内容
     */
    public static String stripHtml(String content){
        //<p>段落替换为换行
        content=content.replaceAll("<p.*?>","");
        //<br><br/>替换为换行 　
        content=content.replaceAll("<brs*/?>","");
        //去掉其它的<>之间的东西
        content=content.replaceAll("<.*?>","");
        //还原HTML//content=HTMLDecoder.decode(content);
        return content;
    }

    public static String replaceHtml(String html){
        String regEx="<.+?>"; //表示标签
        Pattern p=Pattern.compile(regEx);
        Matcher m=p.matcher(html);
        String s=m.replaceAll("");
        return s;
    }

    public static void main(String[] args) {
     String s = "<!DOCTYPE html PUBLIC ''-//WAPFORUM//DTD XHTML Mobile 1.0//EN'' ''http://www.wapforum.org/DTD/xhtml-mobile10.dtd''><html xmlns=''http://www.w3.org/1999/xhtml''><head><meta http-equiv=''Content-Type'' content=''text/html; charset=utf-8'' /><meta id=''viewport'' name=''viewport'' content=''width=320,initial-scale=1,maximum-scale=1,user-scalable=0;'' /><title>概述-白塞病诊断和治疗指南</title><link href=''Pub/css/layout.css'' rel=''stylesheet'' type=''text/css'' /><link href=''Pub/css/public.css'' rel=''stylesheet'' type=''text/css'' /><script type=''text/javascript'' src=''Pub/js/jquery-1.6.1.min.js''></script><script type=''text/javascript'' src=''Pub/js/base.js''></script></head><body><div id=''Layout''><div class=''titleBar''><h1 id= ''1''>1. 概述</h1></div><div class=''mainContainer''><p>白塞病(Behcet's disease，BD)又称贝赫切特病、口-眼-生殖器三联征等。 </p></div></div></body></html>";
//      delHTMLTag(s);
    System.out.println(delHTMLTag(s));
    }

}
