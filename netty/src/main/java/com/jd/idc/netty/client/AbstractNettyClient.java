package com.jd.idc.netty.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jd.idc.netty.server.AbstractNettyServer;
import com.jd.idc.netty.server.NettyConfig;
import com.jd.idc.netty.server.Server.TRANSMISSION_PROTOCOL;

public class AbstractNettyClient implements NettyClient {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractNettyServer.class);
    protected final ClientConfig clientConfig;
    protected ChannelInitializer<? extends Channel> channelInitializer;
	
    public AbstractNettyClient(ClientConfig clientConfig,
            ChannelInitializer<? extends Channel> channelInitializer) 
    {
        this.clientConfig = clientConfig;
        this.channelInitializer = channelInitializer;
    }
    
	@Override
	public TransmissionProtocol getTransmissionProtocol() {
		return TRANSMISSION_PROTOCOL.TCP;
	}

	@Override
	public void startClient() throws Exception {}

	@Override
	public void startClient(String serverIp,int port) throws Exception {
		clientConfig.setPortNumber(port);
		clientConfig.setServerIp(serverIp);
		clientConfig.setServerAddress(new InetSocketAddress(port));
        startClient();
	}

	@Override
	public void stopClient() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public InetSocketAddress getSocketAddress() {
		// TODO Auto-generated method stub
		return clientConfig.getServerAddress();
	}

	@Override
	public ChannelInitializer<? extends Channel> getChannelInitializer() {
		return channelInitializer;
	}

	@Override
	public void setChannelInitializer(
			ChannelInitializer<? extends Channel> initializer) {}

	@Override
	public ClientConfig getClientConfig() {
		return clientConfig;
	}

}
