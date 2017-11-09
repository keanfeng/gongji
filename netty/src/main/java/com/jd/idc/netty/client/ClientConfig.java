package com.jd.idc.netty.client;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;

import java.net.InetSocketAddress;
import java.util.Map;

public class ClientConfig {

	private Map<ChannelOption<?>, Object> channelOptions;

    // reactor多线程模型中的threadPool
    private NioEventLoopGroup workerGroup;

    //workerGroup的线程数
    private int workerThreadCount;
    private InetSocketAddress serverAddress;
    private String serverIp = "";
    private int portNumber = 18090;
    
    protected ChannelInitializer<? extends Channel> channelInitializer;

    public Map<ChannelOption<?>, Object> getChannelOptions() {
        return channelOptions;
    }

    public void setChannelOptions(
            Map<ChannelOption<?>, Object> channelOptions) {
        this.channelOptions = channelOptions;
    }

    public synchronized NioEventLoopGroup getWorkerGroup() {
        if (null == workerGroup) {
            if (0 >= workerThreadCount) {
                workerGroup = new NioEventLoopGroup();
            } else {
                workerGroup = new NioEventLoopGroup(workerThreadCount);
            }
        }
        return workerGroup;
    }

    public void setWorkerGroup(NioEventLoopGroup workerGroup) {
        this.workerGroup = workerGroup;
    }

    public int getWorkerThreadCount() {
        return workerThreadCount;
    }

    public void setWorkerThreadCount(int workerThreadCount) {
        this.workerThreadCount = workerThreadCount;
    }

    public synchronized InetSocketAddress getServerAddress() {
        if (null == serverAddress) {
        	serverAddress = new InetSocketAddress(serverIp,portNumber);
        }
        return serverAddress;
    }

    public void setServerAddress(InetSocketAddress serverAddress) {
        this.serverAddress = serverAddress;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	
}
