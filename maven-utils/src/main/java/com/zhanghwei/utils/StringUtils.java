package com.zhanghwei.utils;

public class StringUtils {
	
	public static boolean isBlank(String str){
		if(str==null) {
			return false;
		}
		//去空格
		str=str.trim();
		if(str.length()==0) {
			return false;
		}
		return true;
	}
	/*
	 * 判断字符串不为空
	 */
	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}
	/*
	 * 判断字符串是否为手机号
	 */
	public static boolean isPhoneNum(String str) {
		String regex="1[35678]\\d{9}";
		return str.matches(regex);
		
	}
	public static void main(String[] args) {
		System.out.println(isNotBlank(" "));
		System.out.println(isPhoneNum("16682061820"));
	}
	
}
