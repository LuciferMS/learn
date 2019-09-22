package com.learn.netty.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: learn
 * @description: channelTest
 * 通过这个例子展现channel向buffer读写数据的操作
 * 更好的理解channel跟stream的区别
 * @author: Elliot
 * @create: 2019-07-31 22:17
 **/
public class ChannelTest {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("NioTest2.txt");
        FileChannel fileChannel = inputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        while(byteBuffer.remaining() > 0){
            byte b = byteBuffer.get();
            System.out.println("char : " + (char)b);
        }
        inputStream.close();
    }
}
