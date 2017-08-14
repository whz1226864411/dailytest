package com.creat.noblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class Client {
    public static void main(String[] args) {
        Selector selector = null;
        try {
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",12580));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            new Thread(new ClientSend(socketChannel)).start();
            while(true){
                selector.select(200);
                Set<SelectionKey>  set = selector.selectedKeys();
                for(SelectionKey selectionKey : set){
                    set.remove(selectionKey);
                    if (selectionKey.isReadable()){
                        SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        if (socketChannel.read(byteBuffer) > 0){
                            System.out.println(new String(byteBuffer.array(),"utf-8"));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(selector != null){
                try {
                    selector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
