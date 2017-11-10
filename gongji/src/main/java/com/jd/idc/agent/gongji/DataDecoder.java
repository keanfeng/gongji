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
        // �ɶ����ȱ�����ڻ�������  
    	 
        if (buffer.readableBytes() >= ConstantValue.PACKAGE_HEAD_LENGTH) {  

            // ��¼��ͷ��ʼ��index  
            int beginReader; 
            // �������п��������ֽ�����
            byte[] dataHeads = new byte[ConstantValue.PACKAGE_HEAD_LENGTH];
            while (true) {  
                // ��ȡ��ͷ��ʼ��index  
                beginReader = buffer.readerIndex();  
                // ��ǰ�ͷ��ʼ��index  
                buffer.markReaderIndex(); 
                
                // ������Э��Ŀ�ʼ��־������whileѭ��  
                buffer.readBytes(dataHeads);
                //�õ���ͷ�̶���������
                String packageHeadFix = ByteUtil.bytesToHexString(
                		Arrays.copyOf(dataHeads, ConstantValue.PACKAGE_HEAD_FIX_LENGTH),false);
                
                if((ConstantValue.PACKAGE_HEAD_MARK
                		+ConstantValue.PROTOCOL_VERSION
                		+ConstantValue.COMMAND_TYPE).equals(packageHeadFix)){
        			break;
        		}
                
                // δ������ͷ���Թ�һ���ֽ�  
                // ÿ���Թ���һ���ֽڣ�ȥ��ȡ����ͷ��Ϣ�Ŀ�ʼ���  
                buffer.resetReaderIndex();  
                buffer.readByte();  
  
                // ���Թ���һ���ֽ�֮��  
                // ���ݰ��ĳ��ȣ��ֱ�ò�����  
                // ��ʱ��Ӧ�ý������ȴ���������ݵ���  
                if (buffer.readableBytes() < ConstantValue.PACKAGE_HEAD_LENGTH) {  
                    return;  
                }  
            }  
  
            // ��Ϣ�ĳ���  
            byte[] dataLengths = Arrays.copyOfRange(dataHeads
            		, ConstantValue.PACKAGE_HEAD_FIX_LENGTH
            		, ConstantValue.PACKAGE_HEAD_FIX_LENGTH + ConstantValue.PACKAGE_LENGTH);
            
            int length =  (dataLengths[0] & 0xFF)
            		| ((dataLengths[1] & 0xFF) << 8)
            		| ((dataLengths[2] & 0xFF) << 16)
            		| ((dataLengths[3] & 0xFF) << 24);
  
            // �ж��������ݰ������Ƿ���  
            if (buffer.readableBytes() < length) {  
                // ��ԭ��ָ��  
                buffer.readerIndex(beginReader);  
                return;  
            }  
  
//            // ��ȡdata����  
//            byte[] dataBody = new byte[length];  
//            buffer.readBytes(dataBody);  
//  
//            Arrays.toString(dataBody);
            
//            DataProtocol protocol = new DataProtocol(data.length, data);  
//            out.add(protocol);
        }  
    }  

}
