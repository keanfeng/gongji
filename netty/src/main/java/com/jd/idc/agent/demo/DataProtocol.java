package com.jd.idc.agent.demo;

import java.util.Arrays;

public class DataProtocol {
	/** 
     * ��Ϣ�Ŀ�ͷ����Ϣ��־ 
     */  
    private int head_data = ConstantValue.HEAD_DATA;  
    /** 
     * ��Ϣ�ĳ��� 
     */  
    private int contentLength;  
    /** 
     * ��Ϣ������ 
     */  
    private byte[] content;  
  
    /** 
     * ���ڳ�ʼ����SmartCarProtocol 
     *  
     * @param contentLength 
     *            Э�����棬��Ϣ���ݵĳ��� 
     * @param content 
     *            Э�����棬��Ϣ������ 
     */  
    public DataProtocol(int contentLength, byte[] content) {  
        this.contentLength = contentLength;  
        this.content = content;  
    }  
  
    public int getHead_data() {  
        return head_data;  
    }  
  
    public int getContentLength() {  
        return contentLength;  
    }  
  
    public void setContentLength(int contentLength) {  
        this.contentLength = contentLength;  
    }  
  
    public byte[] getContent() {  
        return content;  
    }  
  
    public void setContent(byte[] content) {  
        this.content = content;  
    }  
  
    @Override  
    public String toString() {  
        return "SmartCarProtocol [head_data=" + head_data + ", contentLength="  
                + contentLength + ", content=" + Arrays.toString(content) + "]";  
    }  
}
