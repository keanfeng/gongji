package com.my.test.bean;

public class DataPackage {

	//包头标记
	private static String PACKAGE_HEAD_MARK = "ffffffff";
	private static int PACKAGE_HEAD_MARK_NUM = 4; 
	
	//协议版本
	private static String PROTOCOL_VERSION = "01000001";
	private static int PROTOCOL_VERSION_NUM = 4;
	
	//命令类型
	private static String COMMAND_TYPE = "ffffffff";
	private static int COMMAND_TYPE_NUM = 4;
	
	//包体长度
	private static int PACKAGE_LENGTH_NUM = 4;
	
	//保留字段
	private static String RESERVE = "ffffffffffffffffffffffffffffffff";
	private static int RESERVE_NUM = 16;
	
	/**
	 * 包解析入口方法
	 * @param data
	 * @return
	 */
	public static byte[] analysis(byte[] data){
		
	}
	
	public static boolean checkPackageHead(){
		
	}
}
