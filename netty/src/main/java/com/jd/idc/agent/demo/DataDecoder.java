package com.jd.idc.agent.demo;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class DataDecoder extends ByteToMessageDecoder {

	/** 
     * <pre> 
     * Э�鿪ʼ�ı�׼head_data��int���ͣ�ռ��4���ֽ�. 
     * ��ʾ���ݵĳ���contentLength��int���ͣ�ռ��4���ֽ�. 
     * </pre> 
     */  
    public final int BASE_LENGTH = 4 + 4;  
  
    @Override  
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer,  
            List<Object> out) throws Exception {  
        // �ɶ����ȱ�����ڻ�������  
        if (buffer.readableBytes() >= BASE_LENGTH) {  
            // ��ֹsocket�ֽ�������  
            // ��ֹ���ͻ��˴��������ݹ���  
            // ��Ϊ��̫������ݣ��ǲ������  
            if (buffer.readableBytes() > 2048) {  
                buffer.skipBytes(buffer.readableBytes());  
            }  
  
            // ��¼��ͷ��ʼ��index  
            int beginReader;  
  
            while (true) {  
                // ��ȡ��ͷ��ʼ��index  
                beginReader = buffer.readerIndex();  
                // ��ǰ�ͷ��ʼ��index  
                buffer.markReaderIndex();  
                // ������Э��Ŀ�ʼ��־������whileѭ��  
                if (buffer.readInt() == ConstantValue.HEAD_DATA) {  
                    break;  
                }  
  
                // δ������ͷ���Թ�һ���ֽ�  
                // ÿ���Թ���һ���ֽڣ�ȥ��ȡ����ͷ��Ϣ�Ŀ�ʼ���  
                buffer.resetReaderIndex();  
                buffer.readByte();  
  
                // ���Թ���һ���ֽ�֮��  
                // ���ݰ��ĳ��ȣ��ֱ�ò�����  
                // ��ʱ��Ӧ�ý������ȴ���������ݵ���  
                if (buffer.readableBytes() < BASE_LENGTH) {  
                    return;  
                }  
            }  
  
            // ��Ϣ�ĳ���  
  
            int length = buffer.readInt();  
            // �ж��������ݰ������Ƿ���  
            if (buffer.readableBytes() < length) {  
                // ��ԭ��ָ��  
                buffer.readerIndex(beginReader);  
                return;  
            }  
  
            // ��ȡdata����  
            byte[] data = new byte[length];  
            buffer.readBytes(data);  
  
            DataProtocol protocol = new DataProtocol(data.length, data);  
            out.add(protocol);
        }  
    }  

}
