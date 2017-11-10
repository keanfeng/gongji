package com.jd.idc.agent.demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class DataEncoder extends MessageToByteEncoder<DataProtocol> {
	@Override  
    protected void encode(ChannelHandlerContext tcx, DataProtocol msg,  
            ByteBuf out) throws Exception {  
        // д����ϢSmartCar�ľ�������  
        // 1.д����Ϣ�Ŀ�ͷ����Ϣ��־(int����)  
        out.writeInt(msg.getHead_data());  
        // 2.д����Ϣ�ĳ���(int ����)  
        out.writeInt(msg.getContentLength());  
        // 3.д����Ϣ������(byte[]����)  
        out.writeBytes(msg.getContent());  
    }  
}
