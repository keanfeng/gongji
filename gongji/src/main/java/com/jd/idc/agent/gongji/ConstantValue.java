package com.jd.idc.agent.gongji;

public class ConstantValue {

	//��ͷ�ܳ���
	public static int PACKAGE_HEAD_LENGTH = 32;
	//��ͷ�̶����ֳ���
	public static int PACKAGE_HEAD_FIX_LENGTH = 12;
		
	//��ͷ���
	public static String PACKAGE_HEAD_MARK = "ffffffff";
	//��ͷ���ռ���ֽڳ���
	public static int PACKAGE_HEAD_MARK_LENGTH = 4; 
	
	//Э��汾
	public static String PROTOCOL_VERSION = "01000001";
	//Э��汾ռ���ֽڳ���
	public static int PROTOCOL_VERSION_LENGTH = 4;
	
	//��������
	public static String COMMAND_TYPE = "ffffffff";
	//��������ռ���ֽڳ���
	public static int COMMAND_TYPE_LENGTH = 4;
	
	//���峤���ֶ�ռ���ֽڳ���
	public static int PACKAGE_LENGTH = 4;
	
	//�����ֶ�
	public static String RESERVE = "ffffffffffffffffffffffffffffffff";
	//�����ֶ�ռ���ֽڳ���
	public static int RESERVE_LENGTH = 16;
	
	public static String GROUP_SEPARATOR = "7c";
	
}
