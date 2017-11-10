package com.jd.idc.agent.gongji;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import com.jd.idc.utils.ByteUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {
	 
	// �ͻ��������ˣ����ӳɹ����ۺ�  
    @Override  
    public void channelActive(ChannelHandlerContext ctx) throws Exception {  
//        // ����SmartCarЭ�����Ϣ  
//        // Ҫ���͵���Ϣ  
//        String data = "I am client ...";  
//        // ���Ҫ������Ϣ���ֽ�����  
//        byte[] content = data.getBytes();  
//        // Ҫ������Ϣ�ĳ���  
//        int contentLength = content.length;  
//  
//        DataProtocol protocol = new DataProtocol(contentLength, content);  
//  
//        ctx.writeAndFlush(protocol);  
    }  
  
    // ֻ�Ƕ����ݣ�û��д���ݵĻ�  
    // ��Ҫ�Լ��ֶ����ͷŵ���Ϣ  
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg)  
            throws Exception {  
        try {  
            // ���ڻ�ȡ�ͻ��˷�����������Ϣ  
//        	DataProtocol body = (DataProtocol) msg;  
//            System.out.println("Client���ܵĿͻ��˵���Ϣ :" + body.toString()); 
        	
        	ByteBuf buf = (ByteBuf)msg;
			byte[] data = new byte[buf.readableBytes()];
			buf.readBytes(data);
			
			System.out.println(ByteUtil.bytesToHexString(data,false));
  
        } finally {  
            ReferenceCountUtil.release(msg);  
        }  
    }  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)  
            throws Exception {  
        ctx.close();  
    }  
}