package com.creat.logintest;

import net.sf.json.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Created by whz on 2017/10/3.
 */
public class LoginTest implements Runnable{

    private String userName;
    private MyHttpClient client;
    private Map<String, Object> params;
    private CountDownLatch countDownLatch;

    public LoginTest(String userName,CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
        this.userName = userName;
        client = new MyHttpClient();
        params = new HashMap<String, Object>();
    }

    public void run() {
        try {
            countDownLatch.countDown();
            for(int i = 0; i < 1; i++){
                String newUserName = userName.substring(0,4) + (Integer.valueOf(userName.substring(4,8))+i);
                String newPassword = newUserName.substring(2,8);
                params.put("userName",newUserName);
                params.put("userPassword",newPassword);
                CloseableHttpResponse response = client.sendPost("http://corefuture.cn:8080/outnet/netout/login",params,"utf-8",false);
                Header[] headers = response.getHeaders("Set-cookie");
                for(Header header : headers){
                    System.out.println(header.getName()+":"+header.getValue());
                }
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity,"utf-8");
                System.out.println(i + ": 账号:" + newUserName + " 密码:" + newPassword
                        + "->" + result);
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(client != null){
                try {
                    client.closeClient();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
