package com.jd.idc.agent.gongji;

import java.util.Arrays;
import java.util.List;


public class DataProtocol extends ConstantValue {
	
	/** 
     * 消息的开头的信息标志 
     */  
    private DataHead dataHead;
    
    /** 
     * 消息的内容 
     */  
    private List<DataGroup> content;  
  
    /** 
     * 用于初始化，SmartCarProtocol 
     *  
     * @param contentLength 
     *            协议里面，消息数据的长度 
     * @param content 
     *            协议里面，消息的数据 
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
