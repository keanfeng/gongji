package com.jd.idc.netty.server.test;

public class TestServer {

	public static void main(String[] args) {
		ServerManager manager = new ServerManager();
        //manager.startServer();
        try {
			manager.startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
