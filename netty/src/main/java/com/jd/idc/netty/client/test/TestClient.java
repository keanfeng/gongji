package com.jd.idc.netty.client.test;

public class TestClient {

	public static void main(String[] args) {
		ClientManager manager = new ClientManager();
        //manager.startServer();
        try {
			manager.startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
