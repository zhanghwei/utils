package com.zhanghwei.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamUtils {

	/*
	 * 读取文件内容
	 */
	
	public static String getFileContent(File file){
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			byte[] b= new byte[1024];
			String str=null;
			while(inputStream.read(b)!=-1){
				
				str+=new String(b);
			}
			return str;
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String getFileContent(String FileFullName) {
		return getFileContent(new File(FileFullName));
	}
	
	
	public static void main(String[] args) {
		System.out.println(getFileContent("D:\\CMS\\day6\\readme.txt"));
		
	}
}
