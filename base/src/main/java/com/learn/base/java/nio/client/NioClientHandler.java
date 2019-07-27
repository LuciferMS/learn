package com.learn.base.nio.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Elliot
 * 客户端线程类，专门用来接收服务端响应
 */
public class NioClientHandler implements Runnable {

    private Selector selector;

    public NioClientHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
            /**
             * 6.循环等待接入的连接
             */
            for (; ; ) {
                /**
                 *  TODO 获取可用的channel数量
                 */
                int readyChannel = selector.select();
                /**
                 * TODO 如果没有可用的channel就继续循环监听
                 */
                if (readyChannel == 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    /**
                     * 7.根据就绪状态，调用方法处理业务逻辑
                     */
                    /**
                     * 7.1 如果是可读事件
                     */
                    if (selectionKey.isReadable()) {
                        readHandler(selectionKey, selector);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        /**
         * 要从selectionKey中获取已经就绪的channel
         */
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        /**
         * 创建buffer, 因为channel只能从buffer读写数据
         */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        /**
         * 循环读取服务器端响应信息
         */
        String response = "";
        while (socketChannel.read(byteBuffer) > 0) {
            /**
             * 此时buffer是写模式，需要转换成读模式
             */
            byteBuffer.flip();
            /**
             * 读取buffer中的内容
             */
            response += Charset.forName("UTF-8").decode(byteBuffer);
        }

        /**
         * 将channel再次注册到selector上，监听其他可读事件
         */
        socketChannel.register(selector, SelectionKey.OP_READ);
        if (response.length() > 0) {
            System.out.println(response);
        }
    }
}
