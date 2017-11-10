package com.jd.idc.agent.gongji;

public class ConstantValue {

	//包头总长度
	public static int PACKAGE_HEAD_LENGTH = 32;
	//包头固定部分长度
	public static int PACKAGE_HEAD_FIX_LENGTH = 12;
		
	//包头标记
	public static String PACKAGE_HEAD_MARK = "ffffffff";
	//包头标记占用字节长度
	public static int PACKAGE_HEAD_MARK_LENGTH = 4; 
	
	//协议版本
	public static String PROTOCOL_VERSION = "01000001";
	//协议版本占用字节长度
	public static int PROTOCOL_VERSION_LENGTH = 4;
	
	//命令类型
	public static String COMMAND_TYPE = "ffffffff";
	//命令类型占用字节长度
	public static int COMMAND_TYPE_LENGTH = 4;
	
	//包体长度字段占用字节长度
	public static int PACKAGE_LENGTH = 4;
	
	//保留字段
	public static String RESERVE = "ffffffffffffffffffffffffffffffff";
	//保留字段占用字节长度
	public static int RESERVE_LENGTH = 16;
	
	public static String GROUP_SEPARATOR = "7c";
	
}
