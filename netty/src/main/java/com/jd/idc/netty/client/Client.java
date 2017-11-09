package com.jd.idc.netty.client;

import java.net.InetSocketAddress;

import com.jd.idc.netty.server.Server.TransmissionProtocol;

public interface Client {

	public interface TransmissionProtocol{

    }

    // 服务器使用的协议
    public enum TRANSMISSION_PROTOCOL implements TransmissionProtocol {
        TCP,UDP
    }

    TransmissionProtocol getTransmissionProtocol();
    // 启动服务器
    void startClient() throws Exception;

    void startClient(String serverIp,int port) throws Exception;

    // 关闭服务器
    void stopClient() throws Exception;

    InetSocketAddress getSocketAddress();
	
}
