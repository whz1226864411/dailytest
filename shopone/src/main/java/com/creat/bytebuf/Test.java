package com.creat.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/10.
 */
public class Test {
    public static void main(String args[]){
        //服务有一个session域：
         Map<String,Map<String,Object>> sessionMap = new HashMap<String,Map<String,Object>>();
        //①收到请求
        //②判断请求头是否有cookie，判断cookie里是否有sessionId
        //③如果没有，在session域中创建该会话的session，也就是Map<String,Object>
        //用代码实现就是
        Map<String, Object> session = new HashMap<String, Object>();
        //随机生成一个sessionId,例如用uuid生成
        String sessionId = UUID.randomUUID().toString().replace("-","");
        sessionMap.put(sessionId,session);
        //④返回响应时会在响应头里加上set-cookie:sessionId
        //⑤浏览器收到这个set-cookie:sessionId的响应头，就会在浏览器内存里存下这个sessionId的值
        //⑥当浏览器再次请求这个网站，会在http请求头中加上请求头cookie:sessionId
        //⑦服务器再次收到这个请求，就从cookie中获取了sessionId的值
        //如果程序员想获取session，就可以通过
        //Map<String, Object> session = sessionMap.get(sessionId);
    }
}
