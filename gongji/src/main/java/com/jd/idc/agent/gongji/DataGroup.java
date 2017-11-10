package com.jd.idc.agent.gongji;

import com.jd.idc.utils.ByteUtil;

public class DataGroup {

	//�����鳤��
	public int length;
	//����������
	public String content;
	
	public DataGroup DataGroup(byte[] dataGroupArr){
		if(isDataGroup(dataGroupArr)){
			
		}
		return null;
	}
	
	public boolean isDataGroup(byte[] dataGroupArr){
		String dataGroupStr = ByteUtil.bytesToHexString(dataGroupArr,false);
		//����������ַ����д��� ��||�����������һ���ַ����ǡ�|��������Ϊ��һ�������������顣
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
