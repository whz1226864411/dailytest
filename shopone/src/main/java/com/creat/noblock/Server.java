package com.creat.noblock;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/7/31 0031.
 */
public class Server {
    public static void main(String[] args) {
        List<SocketChannel> clients = new ArrayList<SocketChannel>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocketChannel serverSocketChannel = null;
        Selector selector = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(12580));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            while(true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                SelectionKey selectionKey = null;
                while(iterator.hasNext()){
                    selectionKey = iterator.next();
                    iterator.remove();
                    System.out.println("进来一个");
                    if (selectionKey.isValid()) {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
                            try {
                                SocketChannel socketChannel = server.accept();
                                System.out.println(socketChannel);
                                socketChannel.configureBlocking(false);
                                socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
                                clients.add(socketChannel);
                                socketChannel.write(ByteBuffer.wrap("连接成功！".getBytes()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        } else if (selectionKey.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                            try {
                                socketChannel.read(byteBuffer);
                                executorService.execute(new ServerListener(socketChannel, clients, byteBuffer));
                            }catch (IOException i) {
                                clients.remove(socketChannel);
                                socketChannel.close();
                                selectionKey.cancel();
                            }

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
