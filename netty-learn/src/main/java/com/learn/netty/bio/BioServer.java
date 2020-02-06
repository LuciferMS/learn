package com.learn.netty.bio;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    private ServerSocket serverSocket;

    private String ip;

    private int port;

    public BioServer(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void startListen() throws IOException {
        serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(ip, port)); //创建对指定端口及IP的监听

        while (true) {
            accept();
        }
    }

    private void accept() throws IOException {
        //收到客户端的请求
        Socket socket = serverSocket.accept();

        //输入流用于接收客户端传输过来的数据
        InputStream in = socket.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            //按照HTTP协议，请求头和请求体之间为一空行分隔
            if ("".equals(line)) {
                break;
            }
        }

        //输出流用于向客户端发送响应消息，需遵从HTTP协议格式
        OutputStream out = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(out);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("HTTP/1.1 200 OK\n");
        bw.write("Content-Type: text/html; charset=UTF-8\n");
        bw.write("\n");
        bw.write("<html>");
        bw.write("<head>");
        bw.write("<title>");
        bw.write("BIO Http Server");
        bw.write("</title>");
        bw.write("</head>");
        bw.write("<body>");
        bw.write("<h1>Hello World!</h1>");
        bw.write("</body>");
        bw.write("</html>");

        //必须在请求读取和响应写入都处理完毕之后才可以调用close方法，将输入流关闭也会导致输出流不可用
        bw.close();
        writer.close();
        out.close();
        br.close();
        reader.close();
        in.close();
        socket.close();
    }

    public static void main(String[] args) {
        BioServer server = new BioServer("127.0.0.1", 8080);
        try {
            server.startListen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
