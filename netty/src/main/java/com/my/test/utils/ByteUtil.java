package com.my.test.utils;

import java.util.Arrays;

public class ByteUtil {
	
	
	public static int bytesToInt(byte[] src){
		int intValue = 0;
		if(src == null || src.length <= 0){
			return 0;
		}
        for (int i = 0; i < src.length; i++) {
            intValue += (src[i] & 0xFF) << (8 * (3 - i));
        }
        return intValue;
	}
	
	/**
	 * Convert byte[] to hex string.这里我们可以将byte转换成int，然后利用Integer.toHexString(int)来转换成16进制字符串。  
	 * @param src byte[] data  
	 * @return hex string  
	 */     
	public static String bytesToHexString(byte[] src,boolean upperCase){  
	    StringBuilder stringBuilder = new StringBuilder("");  
	    if (src == null || src.length <= 0) {  
	        return null;  
	    }  
	    for (int i = 0; i < src.length; i++) {  
	        int v = src[i] & 0xFF;  
	        String hv = Integer.toHexString(v);  
	        if (hv.length() < 2) {  
	        	hv = "0"+hv;
	        }
	        if(upperCase){
	        	hv = hv.toUpperCase() + " ";
	        }
	        stringBuilder.append(hv);  
	    }  
	    return stringBuilder.toString();  
	}  
	
	public static String[] bytesToHexs(byte[] src){  
	    String[] temp = null; 
	    if (src == null || src.length <= 0) {  
	        return null;  
	    }else{
	    	temp = new String[src.length];
	    }
	    
	    for (int i = 0; i < src.length; i++) {  
	        int v = src[i] & 0xFF;  
	        String hv = Integer.toHexString(v);  
	        if (hv.length() < 2) {  
	            temp[i] = "0"+hv;  
	        }else{
	        	temp[i] = hv;
	        }
	    }  
	    return temp;  
	}  
	
	/** 
	 * Convert hex string to byte[] 
	 * @param hexString the hex string 
	 * @return byte[] 
	 */  
	public static byte[] hexStringToBytes(String hexString) {  
	    if (hexString == null || hexString.equals("")) {  
	        return null;  
	    }  
	    hexString = hexString.toUpperCase();  
	    int length = hexString.length() / 2;  
	    char[] hexChars = hexString.toCharArray();  
	    byte[] d = new byte[length];  
	    for (int i = 0; i < length; i++) {  
	        int pos = i * 2;  
	        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
	    }  
	    return d;  
	}
	
	/** 
	 * Convert char to byte 
	 * @param c char 
	 * @return byte 
	 */  
	private static byte charToByte(char c) {  
	    return (byte) "0123456789ABCDEF".indexOf(c);  
	}  
	 
	//将指定byte数组以16进制的形式打印到控制台  
	public static void printHexString( byte[] b) {    
	    for (int i = 0; i < b.length; i++) {   
	      String hex = Integer.toHexString(b[i] & 0xFF);   
	      if (hex.length() == 1) {   
	        hex = '0' + hex;   
	      }   
	      System.out.print(hex.toUpperCase() );   
	    }   
	   
	 }  
	 
	 public static String bytes2HexString(byte[] b) {  
		 String ret = "";  
		  for (int i = 0; i < b.length; i++) {  
		   String hex = Integer.toHexString(b[ i ] & 0xFF);  
		   if (hex.length() == 1) {  
		    hex = '0' + hex;  
		   }  
		   ret += hex.toUpperCase();  
		  }  
		  return ret;  
	}  
	 
	 public static void testArrayCopy(){
		 int[] arr6 = {3, 7, 2, 1};
		 int[] arr7=Arrays.copyOf(arr6, 12);
		 
		 System.out.println(Arrays.toString(arr6));
		 System.out.println(Arrays.toString(arr7));
	 }
	 
	 public static void main(String args[]){
		 ByteUtil.testArrayCopy();
	 }
}
