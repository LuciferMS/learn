package com.learn.base.nio.client;

import java.io.IOException;

/**
 * @author Elliot
 */
public class CClient {

    public static void main(String[] args) throws IOException {
        NIOClient nioClient = new NIOClient();
        nioClient.start("CClient");
    }

}
