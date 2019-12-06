package com.zhanghwei.utils;

import java.util.Random;

public class StringUtils {
	/*
	 * 判断是否为空
	 */
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
	
	
	/*
	 * 验证邮箱
	 */
	public static boolean isEmail(String  str){
		String regex="[A-Za-z0-9]+@[A-Za-z0-9]+.(com|cn|com.cn|net)";
		
		return str.matches(regex);
	}
	
	
	/*
	 * 判读是否为小写字母
	 */
	public static boolean isLetter(String str){
		if(isBlank(str)){
			 str = str.toLowerCase();
			 String regex="[a-z]+";
			 return str.matches(regex);
		}
		return false;
	}
	
	
	
	/*
	 * 获取随机字符（a-z）
	 */
	public static String getRandomAzChar(int num){
		//保存生成的字符
		StringBuffer ss = new StringBuffer();
		
		//随机的类
		Random random = new Random();
		//ascll码
		int startChar='a'+0;
		//生产随机字符
		char newChar=0;
		for (int i = 0; i < num; i++) {
			newChar=(char) (startChar+random.nextInt(26));
			ss.append(newChar);
		}
		return ss.toString();
	}
	public static char getRandomAzChar(){
		//随机的类
		Random random = new Random();
		//ascll码
		int startChar='a'+0;
		//生产随机字符
		char newChar=(char) (startChar+random.nextInt(26));
			
		return newChar;
	}
	
	
	/*
	 * 生成随机的数字字符
	 */
	public static String getRandomLetter(int num){
		//
		StringBuffer ss = new StringBuffer();
		//生产随机字符
		for (int i = 0; i <num; i++) {
			char newChar = getRandomAzChar();
			ss.append(newChar);
		}
		return ss.toString();	
	}
	public static char getRandomNumberChar(){
		//随机类
		Random random = new Random();
		int startChar='0'+0;
		//随机字符
		char newChar=(char) (startChar+random.nextInt(10));
		return newChar;
	}
	
	
	
	/*
	 * 获取随机字符
	 */
	public static String getRandomLetterAndNumberStr(int num){
		StringBuffer ss = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i <num; i++) {
			if(random.nextInt(36)>10) {
				ss.append(getRandomAzChar());
			}else {
				ss.append(getRandomNumberChar());
			}
		}
		return ss.toString();
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(isNotBlank(" "));
		System.out.println(isPhoneNum("16682061820"));
		System.out.println(isEmail("1274051096@qq.com"));
		System.out.println(isLetter("sss"));
		System.out.println(getRandomAzChar(4));
		System.out.println(getRandomNumberChar());
		for (int i = 0; i < 10; i++) {
		
			System.out.println(getRandomLetterAndNumberStr(4));
		}
		System.out.println(getRandomLetter(4));
		
	}
	
}
