package com.creat.net;

import com.creat.App;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class Server {
    public static void main( String[] args ) throws IOException {
        ServerSocket serverSocket = null;
        try {
            List<Socket> list = new ArrayList<Socket>();
            serverSocket = new ServerSocket(12580);
            while (true){
                Socket socket = serverSocket.accept();
                list.add(socket);
                RequestHandler requestHandler = new RequestHandler(socket,list);
                Thread thread = new Thread(requestHandler);
                thread.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                serverSocket.close();
            }
        }

    }
}
