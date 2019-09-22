package com.learn.netty.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * @program: learn
 * @description: Buffer
 * @author: Elliot
 * @create: 2019-07-31 01:32
 **/
public class BufferTest {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            int randomNumber = new SecureRandom().nextInt(20);
            intBuffer.put(randomNumber);
        }

        intBuffer.flip();

        while(intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
