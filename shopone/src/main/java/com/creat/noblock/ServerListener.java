package com.creat.noblock;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class ServerListener implements Runnable {
    private SocketChannel socketChannel;
    private List<SocketChannel> list;
    private ByteBuffer byteBuffer;
    public ServerListener(SocketChannel socketChannel, List<SocketChannel> list, ByteBuffer byteBuffer){
        this.socketChannel = socketChannel;
        this.list = list;
        this.byteBuffer = byteBuffer;
    }
    public void run() {
        for (SocketChannel send : list) {
            if (send != socketChannel) {
                byteBuffer.flip();
                try {
                    send.write(byteBuffer);
                } catch (IOException e) {
                    e.printStackTrace();
                    list.remove(send);
                    if(send != null){
                        try {
                            send.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
