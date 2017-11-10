package com.jd.idc.agent.gongji;

import java.util.Arrays;
import java.util.List;

import com.jd.idc.utils.ByteUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class DataDecoder extends ByteToMessageDecoder {
 
  
    @Override  
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer,  
            List<Object> out) throws Exception {  
        // 可读长度必须大于基本长度  
    	 
        if (buffer.readableBytes() >= ConstantValue.PACKAGE_HEAD_LENGTH) {  

            // 记录包头开始的index  
            int beginReader; 
            // 缓存区中可用数据字节数组
            byte[] dataHeads = new byte[ConstantValue.PACKAGE_HEAD_LENGTH];
            while (true) {  
                // 获取包头开始的index  
                beginReader = buffer.readerIndex();  
                // 标记包头开始的index  
                buffer.markReaderIndex(); 
                
                // 读到了协议的开始标志，结束while循环  
                buffer.readBytes(dataHeads);
                //得到包头固定部分内容
                String packageHeadFix = ByteUtil.bytesToHexString(
                		Arrays.copyOf(dataHeads, ConstantValue.PACKAGE_HEAD_FIX_LENGTH),false);
                
                if((ConstantValue.PACKAGE_HEAD_MARK
                		+ConstantValue.PROTOCOL_VERSION
                		+ConstantValue.COMMAND_TYPE).equals(packageHeadFix)){
        			break;
        		}
                
                // 未读到包头，略过一个字节  
                // 每次略过，一个字节，去读取，包头信息的开始标记  
                buffer.resetReaderIndex();  
                buffer.readByte();  
  
                // 当略过，一个字节之后，  
                // 数据包的长度，又变得不满足  
                // 此时，应该结束。等待后面的数据到达  
                if (buffer.readableBytes() < ConstantValue.PACKAGE_HEAD_LENGTH) {  
                    return;  
                }  
            }  
  
            // 消息的长度  
            byte[] dataLengths = Arrays.copyOfRange(dataHeads
            		, ConstantValue.PACKAGE_HEAD_FIX_LENGTH
            		, ConstantValue.PACKAGE_HEAD_FIX_LENGTH + ConstantValue.PACKAGE_LENGTH);
            
            int length =  (dataLengths[0] & 0xFF)
            		| ((dataLengths[1] & 0xFF) << 8)
            		| ((dataLengths[2] & 0xFF) << 16)
            		| ((dataLengths[3] & 0xFF) << 24);
  
            // 判断请求数据包数据是否到齐  
            if (buffer.readableBytes() < length) {  
                // 还原读指针  
                buffer.readerIndex(beginReader);  
                return;  
            }  
  
//            // 读取data数据  
//            byte[] dataBody = new byte[length];  
//            buffer.readBytes(dataBody);  
//  
//            Arrays.toString(dataBody);
            
//            DataProtocol protocol = new DataProtocol(data.length, data);  
//            out.add(protocol);
        }  
    }  

}
