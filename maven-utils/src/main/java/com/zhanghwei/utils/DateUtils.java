package com.zhanghwei.utils;

import java.io.ObjectInputStream.GetField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	/*
	 * 根据生日计算年龄
	 */
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
	/*
	 * 给一个时间对象，返回该时间所在月的1日0时0分0秒
	 */
	public  static Date getDateByInitMonth(Date src){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(src);
		calendar.set(Calendar.DAY_OF_MONTH,1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		return calendar.getTime();
	}
	public static Date getTime(String str){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date =null;
		try {
			 date = simpleDateFormat.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDateByInitMonth(date);
	}
	/*
	 * 获取开始日期和结束日期之间有多少天
	 */
	public static int getDayNum(Date date1,Date date2){
		//一天有多少毫秒
		Long dayTime=1000*60*60*24L;
		long startTime = date1.getTime();
		long endTime = date2.getTime();
		System.out.println(startTime);
		System.out.println(endTime);
		Double dayNum=Math.abs((endTime-startTime)/dayTime*1.0);
		System.out.println(dayNum);
		dayNum = Math.ceil(dayNum);
		System.out.println(dayNum);
		return dayNum.intValue()+1;
	}
	public static int getDayNum(Date date){
		Date date2 = new Date();
		
		return getDayNum(date, date2);
	}
	/*
	 * 验证指定日期是否为今天
	 */
	public static boolean isToday(Date theDate){
		Date nowDate = new Date();
		String nowDateStr = dateFormat.format(nowDate);
		String theDateStr = dateFormat.format(theDate);
		return nowDateStr.equals(theDateStr);
	}
	public static boolean isToday(String theDateStr){
		try {
			Date theDate = dateFormat.parse(theDateStr);
			return isToday(theDate);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/*
	 * 获得指定日期的最后一天
	 */
	public static Date getLastDateLnMonth(Date theDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(theDate);
		calendar.add(Calendar.MONTH,1);
		Date firstDateInMonth = getDateByInitMonth(theDate);
		calendar.setTime(firstDateInMonth);
		calendar.add(Calendar.SECOND,-1);
		return calendar.getTime();
	}
	/*
	 * 比较日期
	 */
	public static int compareTime(Date date1,Date date2){
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if(time1==time2) {
	    	return 0;
		}
		if(time1>time2) {
			return 1;
		}
		return -1;
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		System.out.println(getAge("2000-6-20"));

		System.out.println(formatDate.format(getTime("2019-12-06 09:30:33")));
		try {
			Date date = dateFormat.parse("2019-11-11");
			System.out.println(getDayNum(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(isToday("2019-12-05"));
		Date format=null;
		try {
			format = dateTimeFormat.parse("2019-12-06 14:15:33");
			System.out.println(formatDate.format(getLastDateLnMonth(format)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date1 = dateTimeFormat.parse("2019-12-05 14:30:11");
		Date date2 = dateTimeFormat.parse("2019-12-05 14:30:11");
		System.out.println(compareTime(date1, date2));
	}
	
}
