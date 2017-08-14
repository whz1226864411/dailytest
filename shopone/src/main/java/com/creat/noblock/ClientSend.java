package com.creat.noblock;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class ClientSend implements Runnable{
    private SocketChannel socketChannel;
    public ClientSend(SocketChannel channel){
        this.socketChannel = channel;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            try {
                socketChannel.write(ByteBuffer.wrap(scanner.nextLine().getBytes()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
