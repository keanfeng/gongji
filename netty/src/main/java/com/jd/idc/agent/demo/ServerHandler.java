package com.jd.idc.agent.demo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	// 用于获取客户端发送的信息  
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg)  
            throws Exception {  
        // 用于获取客户端发来的数据信息  
    	DataProtocol body = (DataProtocol) msg;  
        System.out.println("Server接受的客户端的信息 :" + body.toString());  
  
        // 会写数据给客户端  
        String str = "Hi I am Server ...";  
        DataProtocol response = new DataProtocol(str.getBytes().length,  
                str.getBytes());  
        // 当服务端完成写操作后，关闭与客户端的连接  
        ctx.writeAndFlush(response);  
        // .addListener(ChannelFutureListener.CLOSE);  
  
    }  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)  
            throws Exception {  
        // cause.printStackTrace();  
        ctx.close();  
    }  
	
}
