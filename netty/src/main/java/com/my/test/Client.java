package com.my.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {

	public static void main(String[] args) throws Exception {
		EventLoopGroup workgroup = new NioEventLoopGroup();
		Bootstrap b = new Bootstrap();
		b.group(workgroup)
		.channel(NioSocketChannel.class)
		.option(ChannelOption.SO_RCVBUF, 100*1024)
		.handler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel sc) throws Exception {
				sc.pipeline().addLast(new ClientHandler());
			}
		});
		
		ChannelFuture cf1 = b.connect("10.12.136.38", 18090).sync();
//		ChannelFuture cf1 = b.connect("127.0.0.1", 8765).sync();

		
		//buf
		cf1.channel().write(Unpooled.copiedBuffer("111".getBytes()));
		cf1.channel().write(Unpooled.copiedBuffer("222".getBytes()));
		cf1.channel().write(Unpooled.copiedBuffer("333".getBytes()));
		cf1.channel().write(Unpooled.copiedBuffer("444".getBytes()));
		
		cf1.channel().write(Unpooled.copiedBuffer("777".getBytes()));
		cf1.channel().write(Unpooled.copiedBuffer("888".getBytes()));
		cf1.channel().write(Unpooled.copiedBuffer("999".getBytes()));
		cf1.channel().write(Unpooled.copiedBuffer("000".getBytes()));
		cf1.channel().flush();
		//cf1.addListener(ChannelFutureListener.CLOSE); //消息发送完成后，自动关闭连接
		cf1.channel().closeFuture().sync();
		
		
		workgroup.shutdownGracefully();
	}
	
	
}
