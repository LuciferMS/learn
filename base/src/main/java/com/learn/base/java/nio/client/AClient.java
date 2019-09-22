package com.learn.base.java.nio.client;

import java.io.IOException;

/**
 * @author Elliot
 */
public class AClient {

    public static void main(String[] args) throws IOException {
        NIOClient nioClient = new NIOClient();
        nioClient.start("AClient");
    }

}
