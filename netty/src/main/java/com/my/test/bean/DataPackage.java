package com.my.test.bean;

import java.util.Arrays;

import com.my.test.utils.ByteUtil;

public class DataPackage {

	//包头长度
	private static int PACKAGE_HEAD_LENGTH = 32;
	private static int PACKAGE_HEAD_FIX_LENGTH = 12;
		
	//包头标记
	private static String PACKAGE_HEAD_MARK = "ffffffff";
	private static int PACKAGE_HEAD_MARK_LENGTH = 4; 
	
	//协议版本
	private static String PROTOCOL_VERSION = "01000001";
	private static int PROTOCOL_VERSION_LENGTH = 4;
	
	//命令类型
	private static String COMMAND_TYPE = "ffffffff";
	private static int COMMAND_TYPE_LENGTH = 4;
	
	//包体长度
	private static int PACKAGE_LENGTH = 4;
	
	//保留字段
	private static String RESERVE = "ffffffffffffffffffffffffffffffff";
	private static int RESERVE_LENGTH = 16;
	
	/**
	 * 包解析入口方法
	 * 	1、接收字节数组，并检测包头数据，循环遍历数据数组，直到找到包头位置；
	 * 	2、解析包体内容，如果一个数据包内容完整，发送数据集合进行数据存储；
	 * 	3、循环解析包内容，直到包数据解析完成
	 * 	4、如有剩余数据为解析完成，并不是一个完整数据包，将剩余数据返回
	 * 	5、如果字节数组内容不是一个完整数据包，将整个数据返回
	 * 	
	 * @param data
	 * @return list
	 */
	public static byte[] analysis(byte[] data){
		byte[] remandData ;
		//解析指针起始位置为0
		int index = 0;
		int dataLength = data.length;
		boolean ifdo = true;
		
		do{
			if((dataLength-index)>PACKAGE_HEAD_LENGTH){
				if(checkPackageHead(Arrays.copyOfRange(data,index, index+PACKAGE_HEAD_LENGTH))){
					index += PACKAGE_HEAD_LENGTH;
					System.out.println("ok");
				}else{
					index++;
				}
			}else{
				ifdo = false;
			}			
			System.out.println("====================================== " + index);
		}while(ifdo);
			
		if(index<dataLength){
			remandData = Arrays.copyOfRange(data, index, dataLength);
		}else{
			remandData = new byte[0];
		}
		
		return remandData;
	}
	
	public static boolean checkPackageHead(byte[] headData){
		//截取字符串
		String packageHeadFix = ByteUtil.bytesToHexString(Arrays.copyOf(headData, PACKAGE_HEAD_FIX_LENGTH),false);
		String reserve = ByteUtil.bytesToHexString(Arrays.copyOfRange(headData, PACKAGE_HEAD_FIX_LENGTH+4,headData.length),false);
		
		if((PACKAGE_HEAD_MARK+PROTOCOL_VERSION+COMMAND_TYPE).equals(packageHeadFix)
				&&RESERVE.equals(reserve)){
			return true;
		}
		
		return false;
	}
	
	public static void analysisPackageHead(byte[] bodyData){
		
	}
	
	
	
	
}
