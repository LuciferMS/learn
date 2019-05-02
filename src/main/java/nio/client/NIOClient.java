package nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * 客户端
 * @author Elliot
 */
public class NIOClient {

    public void start(String nickname) throws IOException {
        /**
         * 连接服务器端
         * 触发服务端的接入事件，断点调试过
         */
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",  10086));

        /**
         * 接受服务器端响应
         * 新开一个线程来处理
         */
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NioClientHandler(selector)).start();

        /**
         * 向服务器端发送数据
         */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String request = sc.nextLine();
            if(request != null && request.length() > 0){
                /**
                 * 发送数据
                 * 先将数据放入buffer中
                 */
                socketChannel.write(Charset.forName("UTF-8").encode(nickname + "::" + request));
            }
        }

    }

}
