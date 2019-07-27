package nio.client;

import java.io.IOException;

/**
 * @author Elliot
 */
public class BClient {

    public static void main(String[] args) throws IOException {
        NIOClient nioClient = new NIOClient();
        nioClient.start("BClient");
    }

}
