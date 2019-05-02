package netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;
import netty.NettyConfig;

/**
 * 接受/处理/响应客户端websocket请求的核心业务处理类
 * @author Elliot
 */
public class MyWebSocketHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketServerHandshaker handshaker;

    private static final String WEB_SOCKET_URL = "ws://localhost:8888/websocket";

    /**
     * 客户端与服务端建立连接的时候调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.group.add(ctx.channel());
        System.out.println("客户端与服务端连接已建立....");
    }

    /**
     * 客户端与服务端断开连接的时候调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        NettyConfig.group.remove(ctx.channel());
        System.out.println("客户端与服务端连接已断开....");
    }

    /**服务端接客户端发送过来的数据结束之后调用
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    /**
     * 工程出现异常的时候调用
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 服务端处理客户端websocket请求的核心方法
     * @param channelHandlerContext
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        /**
         * 1.处理客户端向服务端发起的http握手请求的业务
         * 2.处理websocket连接业务
         */
        if (msg instanceof FullHttpMessage){
            handleHttpRequest(channelHandlerContext, (FullHttpRequest)msg);
        }else if (msg instanceof WebSocketFrame){

        }
    }

        /**
         * 处理客户端向服务端发起http握手请求的业务
         * @param ctx
         * @param request
         */
        private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request){
            if(!request.getDecoderResult().isSuccess() || !"websocket".equals(request.headers().get("Upgrade"))){
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return ;
        }
            WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(WEB_SOCKET_URL,null, false);
            handshaker = wsFactory.newHandshaker(request);
            if (handshaker == null){
                WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
            }else{
                handshaker.handshake(ctx.channel(), request);
            }
    }

    /**
     * 服务端向客户端发送响应消息
     * @param ctx
     * @param request
     * @param response
     */
    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest request,
                                  DefaultFullHttpResponse response){
        if (response.status().code() != 200){
            ByteBuf buf = Unpooled.copiedBuffer(response.status().toString(), CharsetUtil.UTF_8);
            response.content().writeBytes(buf);
            buf.release();
        }
        /**
         * 服务端向客户端发送数据
         */
        ChannelFuture f = ctx.channel().writeAndFlush(response);
        if (response.status().code() != 200){
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }
}
