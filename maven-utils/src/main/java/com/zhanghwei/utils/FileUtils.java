package com.zhanghwei.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	/*
	 * 根据文件，截取文件名
	 * 
	 */
	/*public static String getExtName(String fileName){
		//写一个异常
		if(fileName==null||"".equals(fileName)){
			throw new RuntimeException("文件名不能为空");
		}
		String extName = fileName.substring(fileName.lastIndexOf("."));
		
		return extName;
	}*/
	public static String getExtName(String fileName){
		//如果传入的文件名为空，那么就给出一个异常
		if(fileName==null||"".equals(fileName)){
			throw new RuntimeException("文件名不能为空");
		}
		if(fileName.indexOf(".")<=-1){
			throw new RuntimeException(fileName+":该文件名没有包含拓展名");
		}
		
		String extName = fileName.substring(fileName.lastIndexOf("."));
		return extName;
	}
	
	
	
	/*
	 * 获取当前用户目录
	 */
	/*public static String getSystemUserHome(){
		return System.getProperty("user.home");
	}*/
	public static String getSystemYserHome(){
		return System.getProperty("user.home");
	}
	/*
	 * 读取文件内容
	 */
	@SuppressWarnings("resource")
	public static String readTextFileByLine(String pathname){
		StringBuffer ss = new StringBuffer();
		BufferedReader br =null;
		try {
			 br = new BufferedReader(new FileReader(new File(pathname)));
			 do {
				 ss.append(br.readLine());
				 ss.append("\r\n");
			 }while(br.read()!=-1);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			StreamUtils.closeAll(br);
		}
		return ss.toString();
	}
	
	/*
	 * 按行读取文件内容到list集合
	 */
	public static List<String> readTextFileOfList(String pathname){
		BufferedReader br =null;
		List<String> list = new ArrayList<>();
		
		try {
			 br = new BufferedReader(new FileReader(new File(pathname)));
			 do {
				 list.add(br.readLine());
				 
			 }while(br.read()!=-1);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	/*
	 * 递归删除文件
	 */
	
	
	public static void main(String[] args) {
		System.out.println(getExtName("ss.jsp"));
		String property = System.getProperty("user.home");
		String getenv = System.getenv("JAVA_HOME");
		System.out.println(property);
		System.out.println(getenv);
		String property2 = System.getProperty("java.io.tmpdir");
		System.out.println(property2);
		//System.out.println(readTextFileByLine("C:\\Users\\Lenovo\\Desktop\\pom.xml"));
		System.out.println(readTextFileOfList("C:\\Users\\Lenovo\\Desktop\\pom.xml"));
	}
	
}
