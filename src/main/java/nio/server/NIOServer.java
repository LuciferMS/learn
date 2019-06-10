package nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO服务器端
 * @author Elliot
 */
public class NIOServer {


    /**
     * 服务器启动
     * 相当于绑定端口之后开了一条线程来监听端口的传入事件，并进行相应的处理
     */
    public void start() throws IOException {
        /**
         * 1.创建selector
         *   通过open方法获取selector对象
         */
        Selector selector = Selector.open();
        /**
         * 2.通过serverSocketChannel创建channel通道
         *
         */
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        /**
         * 3.为channel通道绑定监听端口号
         */
        serverSocketChannel.bind(new InetSocketAddress(10086));
        /**
         * 4.设置channel为非阻塞模式
         */
        serverSocketChannel.configureBlocking(false);
        /**
         * 5.将channel注册到selector上，监听连接事件
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("=======服务器启动成功=======");
        /**
         * 6.循环等待接入的连接
         */
        for(;;){
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
            while(iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                /**
                 * 7.根据就绪状态，调用方法处理业务逻辑
                 */
                /**
                 *  7.1 如果是接入事件
                 */
                if (selectionKey.isAcceptable()){
                    /**
                     * 在客户端连接端口的时候 ，会触发这个事件
                     *
                     */
                    acceptHandler(serverSocketChannel, selector);
                }
                /**
                 * 7.2 如果是可读事件
                 */
                if (selectionKey.isReadable()){
                    readHandler(selectionKey, selector);
                }
            }
        }

    }

    /**
     * 接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        /**
         * 如果是接入事件，创建socketChannel
         * 这里即使nio比起bio的优化之处，有客户端接入的时候，创建的是一个socketChannel与其通信，而不是一个socket
         */
        SocketChannel socketChannel = serverSocketChannel.accept();
        /**
         * 将socketChannel设置成非阻塞工作模式
         */
        socketChannel.configureBlocking(false);
        /**
         * 将channel注册到selector上，监听 可读事件
         */
        socketChannel.register(selector, SelectionKey.OP_READ);
        /**
         * 回复客户端提示信息
         */
        socketChannel.write(Charset.forName("UTF-8")
                .encode("您与聊天室里其他人都不是好友关系，请注意隐私安全"));
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
         * 循环读取客户端请求信息
         */
        String request = "";
        while(socketChannel.read(byteBuffer) > 0){
            /**
             * 此时buffer是写模式，需要转换成读模式
             */
            byteBuffer.flip();
            /**
             * 读取buffer中的内容
             */
            request += Charset.forName("UTF-8").decode(byteBuffer);
        }

        /**
         * 将channel再次注册到selector上，监听其他可读事件
         */
        socketChannel.register(selector, SelectionKey.OP_READ);
        /**
         * 将客户端发送的请求信息，广播给其他客户端
         */
        if (request.length() > 0){
            broadCast(selector, socketChannel, request);
        }
    }

    /**
     * 将信息广播到其他客户端
     * @param selector
     * @param socketChannel
     * @param request
     */
    private void broadCast(Selector selector, SocketChannel socketChannel, String request){
        /**
         * 获取到所有接入的客户端的channel
         */
        Set<SelectionKey> selectionKeys = selector.keys();
        /**
         * 遍历所有channel，向通道中写入数据
         * 这里要剔除掉发送方的channel
         */
        for (SelectionKey selectionKey : selectionKeys){
            Channel targetChannel = selectionKey.channel();

            if (targetChannel instanceof SocketChannel
                    && targetChannel != socketChannel){
                try {
                    /**
                     * 写入信息
                     */
                    ((SocketChannel) targetChannel).write(
                            Charset.forName("UTF-8").encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) throws IOException {
        NIOServer nioServer = new NIOServer();
        nioServer.start();
    }
}
