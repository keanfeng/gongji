package com.my.test.bean;

import com.my.test.utils.ByteUtil;

public class DataGroup {

	public static int GROUP_LENGTH = 2;
	
	public static int getContentLength(byte[] len){
		return ByteUtil.bytesToInt(len);
	}
}
