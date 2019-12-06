package com.zhanghwei.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StreamUtils {
	/*
	 * 关闭流的方法
	 */
	public static void closeAll(AutoCloseable...autoCloseables){
		if(autoCloseables!=null){
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

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
	
	/*
	 * 以流的方式，读取文本文件内容
	 */
	public static String readTextFile(File file){
		FileInputStream inputStream =null;
		try {
			 inputStream = new FileInputStream(file);
			 byte[] b= new byte[1024];
			 String str="";
			 while(inputStream.read(b)!=-1){
				 str+=new String(b);
			 }
			 return str;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(inputStream);
		}
		return null;
	}
	/*
	 * 根据文件全名读取文件内容
	 * 
	 */
	public static String readTextFile(String fileFullName){
		return readTextFile(new File(fileFullName));
	}
	
	public static void main(String[] args) {
		System.out.println(getFileContent("D:\\CMS\\day6\\readme.txt"));
		System.out.println(readTextFile(new File("D:\\CMS\\day6\\readme.txt"))+"======");
	}
}
