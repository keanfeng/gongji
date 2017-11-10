package com.jd.idc.agent.gongji;

import com.jd.idc.utils.ByteUtil;

public class DataGroup {

	//数据组长度
	public int length;
	//数据组内容
	public String content;
	
	public DataGroup DataGroup(byte[] dataGroupArr){
		if(isDataGroup(dataGroupArr)){
			
		}
		return null;
	}
	
	public boolean isDataGroup(byte[] dataGroupArr){
		String dataGroupStr = ByteUtil.bytesToHexString(dataGroupArr,false);
		//如果数据组字符串中存在 “||”，并且最后一个字符串是“|”，及认为是一个完整的数据组。
		return ((dataGroupStr.indexOf(ConstantValue.GROUP_SEPARATOR+ConstantValue.GROUP_SEPARATOR) != -1 ) 
				&& (dataGroupStr.substring(dataGroupStr.length()-2)).equals(ConstantValue.GROUP_SEPARATOR));
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
