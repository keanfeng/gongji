package com.jd.idc.agent.demo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	// ���ڻ�ȡ�ͻ��˷��͵���Ϣ  
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg)  
            throws Exception {  
        // ���ڻ�ȡ�ͻ��˷�����������Ϣ  
    	DataProtocol body = (DataProtocol) msg;  
        System.out.println("Server���ܵĿͻ��˵���Ϣ :" + body.toString());  
  
        // ��д���ݸ��ͻ���  
        String str = "Hi I am Server ...";  
        DataProtocol response = new DataProtocol(str.getBytes().length,  
                str.getBytes());  
        // ����������д�����󣬹ر���ͻ��˵�����  
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
