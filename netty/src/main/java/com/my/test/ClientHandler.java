package com.my.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.util.Arrays;

import com.my.test.utils.ByteUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {

	private int count;
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
				//do something msg
				ByteBuf buf = (ByteBuf)msg;
				byte[] data = new byte[buf.readableBytes()];
				buf.readBytes(data);
				
				System.out.println(ByteUtil.bytesToHexString(data,false));
				System.out.println(Arrays.toString(ByteUtil.bytesToHexs(data)));
				
				String request = new String(data, "GBK");
				System.out.println("Client: " + request);
				count++;
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + count);
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
}
