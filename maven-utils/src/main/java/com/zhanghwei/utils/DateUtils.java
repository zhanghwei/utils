package com.zhanghwei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static int getAge(Date birthDate){
		//获得日历控件
		Calendar calendar = Calendar.getInstance();
		int nowYear = calendar.get(Calendar.YEAR);
		int nowMonth = calendar.get(Calendar.MONTH);
		int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
		//设置生日
		calendar.setTime(birthDate);
		int birYear = calendar.get(Calendar.YEAR);
		int birMonth = calendar.get(Calendar.MONTH);
		int birDay = calendar.get(Calendar.DAY_OF_MONTH);
		//年龄
		int age=nowYear-birYear;
		//如果生日的月份大于当前月份时，年龄-1
		if(birMonth>nowMonth) {
			age--;
		}
		//如果月份相等，判断日期
		if(birMonth==nowMonth&&nowDay<birDay){
			age--;
		}
		return age;
	}
	/*
	 * 根据出生日期计算年龄
	 * 
	 */
	public static int getAge(String birthDateStr){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate =null;
		try {
			birthDate = simpleDateFormat.parse(birthDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAge(birthDate);
	}
	public static void main(String[] args) {
		System.out.println(getAge("2000-6-20"));
	}
	
}
