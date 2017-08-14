package com.creat.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class Client {
    public static void main(String[] args) throws UnknownHostException {
        try {
            final Socket socket = new Socket(InetAddress.getLocalHost(),12580);
            final Scanner scanner = new Scanner(System.in);
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    InputStreamReader in = null;
                    try {
                        in = new InputStreamReader(socket.getInputStream());
                        while (true){
                            char[] cbuf = new char[100];
                            int lens = 0;
                            if((lens = in.read(cbuf)) > 0){
                                System.out.println(String.valueOf(cbuf));
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        if(in != null){
                            try {
                                in.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            thread.start();
            OutputStream outputStream = socket.getOutputStream();
            while(scanner.hasNext()){
                outputStream.write(scanner.nextLine().getBytes());
                outputStream.flush();
            }
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
