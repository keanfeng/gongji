package com.jd.idc.netty.server.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jd.idc.netty.server.AbstractNettyServer;
import com.jd.idc.netty.server.AppContext;

public class ServerManager {
	private AbstractNettyServer tcpServer;
    public ServerManager() {
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
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
