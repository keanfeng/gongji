package com.jd.idc.netty.client.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jd.idc.netty.server.AbstractNettyServer;
import com.jd.idc.netty.server.AppContext;

public class ClientManager {
	private AbstractNettyServer tcpServer;
    public ClientManager() {
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans2.xml");
    	AppContext ac = new AppContext();
    	ac.setApplicationContext(context);
        tcpServer = (AbstractNettyServer)AppContext.getBean(AppContext.TCP_SERVER);
    }

    public void startServer(int port) throws Exception {
        tcpServer.startServer(port);
    }

    public void startServer() throws Exception {
        tcpServer.startServer();
    }
    public void stopServer() throws Exception {
        tcpServer.stopServer();
    }
}
