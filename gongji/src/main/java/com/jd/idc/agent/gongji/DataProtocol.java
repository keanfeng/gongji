package com.jd.idc.agent.gongji;

import java.util.Arrays;
import java.util.List;


public class DataProtocol extends ConstantValue {
	
	/** 
     * ��Ϣ�Ŀ�ͷ����Ϣ��־ 
     */  
    private DataHead dataHead;
    
    /** 
     * ��Ϣ������ 
     */  
    private List<DataGroup> content;  
  
    /** 
     * ���ڳ�ʼ����SmartCarProtocol 
     *  
     * @param contentLength 
     *            Э�����棬��Ϣ���ݵĳ��� 
     * @param content 
     *            Э�����棬��Ϣ������ 
     */  
    public DataProtocol(DataHead dataHead, List<DataGroup> content) {  
        this.dataHead = dataHead;  
        this.content = content;  
    }  

    public DataHead getDataHead() {
		return dataHead;
	}
    
	public void setDataHead(DataHead dataHead) {
		this.dataHead = dataHead;
	}
	
	public List<DataGroup> getContent() {
		return content;
	}
	
	public void setContent(List<DataGroup> content) {
		this.content = content;
	}

	@Override  
    public String toString() {  
//        return "SmartCarProtocol [head_data=" + head_data + ", contentLength="  
//                + contentLength + ", content=" + Arrays.toString(content) + "]";  
		return null;
    }  
}
