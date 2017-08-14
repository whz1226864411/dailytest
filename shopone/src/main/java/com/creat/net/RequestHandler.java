package com.creat.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class RequestHandler implements Runnable{
    private Socket socket;
    private List<Socket> list;
    public RequestHandler(Socket socket,List<Socket> list){
        this.socket = socket;
        this.list = list;
    }
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            out.write("连接成功！".getBytes());
            while (true) {
                int len = 0;
                if(!socket.isClosed()){
                    if ((len = in.read(bytes)) > 0) {
                        for (Socket socket : list) {
                            if(socket != this.socket){
                                OutputStream outputStream = socket.getOutputStream();
                                outputStream.write(bytes,0,len);
                            }

                        }
                    }
                }else {
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                list.remove(socket);
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
