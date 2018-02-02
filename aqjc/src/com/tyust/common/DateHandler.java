package com.tyust.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DateHandler {
	/**
	 * 把一个日期转换成指定格式的字符串
	 * @param time
	 * @return
	 */
	public static String dateToString(Date time) {
		String ctime = "";
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (time != null) {
			ctime = formatter.format(time);
		}
		return ctime;
	}
	
	public static String dateToStringHourMinute(Date time) {
		String ctime = "";
		SimpleDateFormat formatter;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if (time != null) {
			ctime = formatter.format(time);
		}
		return ctime;
	}
	// 把String转换成Date
	public static Date changeStringToDate(String time) throws ParseException {
		Date t = null;
		if (time != null && !time.trim().equals("")) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				t= formatter.parse(time);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new java.lang.RuntimeException(e);
			}
		}
		return t;
	}
	// 把String转换成Date如：2010-01-07 13:10:10,yyyy-MM-dd HH:mm:ss
	public static Date changeStringToDate(String time,String fomat) throws ParseException {
		Date t = null;
		if (time != null && !time.trim().equals("")) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat(fomat);
				t= formatter.parse(time);
			} catch (ParseException e) {
				e.printStackTrace();
				throw new java.lang.RuntimeException(e);
			}
		}
		return t;
	}
	//把Date转换成String如：2010-01-07 13:10:10
	public static String dateToString(Date time,String fomat) {
		String ctime = "";
		SimpleDateFormat formatter = new SimpleDateFormat(fomat);
		if (time != null) {
			ctime = formatter.format(time);
		}
		return ctime;
	}
 
	/**
	 * 获得下季度第一天 
	 * @author zxg
	 * @param month
	 * @return
	 */
	public static Date getNextSeasonFirstDay(int month){ 
	       int array[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}}; 
	       int season = 1; 
	       if(month>=1&&month<=3){ 
	           season = 2; 
	       } 
	       if(month>=4&&month<=6){ 
	           season = 3; 
	       } 
	       if(month>=7&&month<=9){ 
	           season = 4; 
	       } 
	       if(month>=10&&month<=12){ 
	           season = 1; 
	       } 
	       int start_month = array[season-1][0]; 
	        
	       Date date = new Date(); 
	       SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式    
	       String  years  = dateFormat.format(date);    
	       int years_value = Integer.parseInt(years); 
	       if(month>=10&&month<=12){
	    	   years_value++;
	       }
	       int start_days =1;//years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month); 
	       String seasonDateStr = years_value+"-"+start_month+"-"+start_days; 
	       Date seasonDate=new Date();
			try {
				seasonDate = changeStringToDate(seasonDateStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       return seasonDate; 
	        
	   } 
	/**
	 * 获得季度的第一天和最后一天
	 * @author zxg
	 * @param month
	 * @param isThisSeason:
	 * 			(1)true:本季度第一天和最后一天
	 * 			(2)false:上季度第一天和最后一天
	 * @return
	 */
    public static String getSeasonFirstEndDay(int month,boolean isThisSeason){ 
        int array[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}}; 
        int season = 1; 
        if(month>=1&&month<=3){ 
        	if(isThisSeason){
	    		   season = 1; 
	    	   }else{
	    		   season = 4;
	    	   } 
        } 
        if(month>=4&&month<=6){ 
        	if(isThisSeason){
	    		   season = 2; 
	    	   }else{
	    		   season = 1;
	    	   } 
        } 
        if(month>=7&&month<=9){ 
        	if(isThisSeason){
	    		   season = 3; 
	    	   }else{
	    		   season = 2;
	    	   } 
        } 
        if(month>=10&&month<=12){ 
        	if(isThisSeason){
	    		   season = 4; 
	    	   }else{
	    		   season = 3;
	    	   } 
        } 
        int start_month = array[season-1][0]; 
        int end_month = array[season-1][2]; 
         
        Date date = new Date(); 
        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式    
        String  years  = dateFormat.format(date);    
        int years_value = Integer.parseInt(years); 
        if(month>=1&&month<=3&&!isThisSeason){
        	years_value--;
        }
        int start_days =1;//years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month); 
        int end_days = getLastDayOfMonth(years_value,end_month); 
        String seasonDate = years_value+"-"+start_month+"-"+start_days+";"+years_value+"-"+end_month+"-"+end_days; 
        return seasonDate; 
         
    } 
	/**
	 * 获得下季度的第一天和最后一天
	 * @author zxg
	 * @param month
	 * @return
	 */
    public static String getDownSeasonFirstEndDay(int month){ 
        int array[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}}; 
        int season = 1; 
        if(month>=1&&month<=3){ 
	    	season = 2; 
        } 
        if(month>=4&&month<=6){ 
	    	season = 3; 
        } 
        if(month>=7&&month<=9){ 
	    	season = 4; 
        } 
        if(month>=10&&month<=12){ 
	    	season = 1; 
        } 
        int start_month = array[season-1][0]; 
        int end_month = array[season-1][2]; 
         
        Date date = new Date(); 
        SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式    
        String  years  = dateFormat.format(date);    
        int years_value = Integer.parseInt(years); 
        if(month>=10&&month<=12){
        	years_value++;
        }
        int start_days =1;//years+"-"+String.valueOf(start_month)+"-1";//getLastDayOfMonth(years_value,start_month); 
        int end_days = getLastDayOfMonth(years_value,end_month); 
        String seasonDate = years_value+"-"+start_month+"-"+start_days+";"+years_value+"-"+end_month+"-"+end_days; 
        return seasonDate; 
         
    } 
	/**
	 * 获得季度首月的25号
	 * （业务需求改变，要求改为季度首月10号）
	 * @author zxg
	 * @param month
	 * @param isThisSeason:
	 * 			(1)true:本季度首月的25号 （本季度首月10号）
	 * 			(2)false:下季度首月的25号 （下季度首月10号）
	 * @return
	 */
	public static Date getSeasonTwentyFive(int month,boolean isThisSeason){ 
	       int array[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}}; 
	       int season = 1; 
	       if(month>=1&&month<=3){
	    	   if(isThisSeason){
	    		   season = 1; 
	    	   }else{
	    		   season = 2;
	    	   }
	       } 
	       if(month>=4&&month<=6){ 
	    	   if(isThisSeason){
	    		   season = 2; 
	    	   }else{
	    		   season = 3;
	    	   }
	       } 
	       if(month>=7&&month<=9){ 
	    	   if(isThisSeason){
	    		   season = 3; 
	    	   }else{
	    		   season = 4;
	    	   } 
	       } 
	       if(month>=10&&month<=12){ 
	    	   if(isThisSeason){
	    		   season = 4; 
	    	   }else{
	    		   season = 1;
	    	   } 
	       } 
	       int start_month = array[season-1][0]; 
	        
	       Date date = new Date(); 
	       SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式    
	       String  years  = dateFormat.format(date);    
	       int years_value = Integer.parseInt(years); 
	       if(month>=10&&month<=12&&!isThisSeason){
	    	   years_value++;
	       }
	       int start_days =10; 
	       String seasonDateStr = years_value+"-"+start_month+"-"+start_days; 
	       Date seasonDate=new Date();
			try {
				seasonDate = changeStringToDate(seasonDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	       return seasonDate; 
	        
	   }
	/**
	 * 获得季度首月的26号
	 * （业务需求改变，要求改为季度首月11号）
	 * @author zxg
	 * @param month
	 * @param isThisSeason:
	 * 			(1)true:本季度首月的26号 （本季度首月11号）
	 * 			(2)false:上季度首月的26号  （上季度首月11号）
	 * @return
	 */
	public static Date getSeasonTwentySix(int month,boolean isThisSeason){ 
	       int array[][] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}}; 
	       int season = 1; 
	       if(month>=1&&month<=3){
	    	   if(isThisSeason){
	    		   season = 1; 
	    	   }else{
	    		   season = 4;
	    	   }
	       } 
	       if(month>=4&&month<=6){ 
	    	   if(isThisSeason){
	    		   season = 2; 
	    	   }else{
	    		   season = 1;
	    	   }
	       } 
	       if(month>=7&&month<=9){ 
	    	   if(isThisSeason){
	    		   season = 3; 
	    	   }else{
	    		   season = 2;
	    	   } 
	       } 
	       if(month>=10&&month<=12){ 
	    	   if(isThisSeason){
	    		   season = 4; 
	    	   }else{
	    		   season = 3;
	    	   } 
	       } 
	       int start_month = array[season-1][0]; 
	        
	       Date date = new Date(); 
	       SimpleDateFormat   dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式    
	       String  years  = dateFormat.format(date);    
	       int years_value = Integer.parseInt(years); 
	       if(month>=1&&month<=3&&!isThisSeason){
	        	years_value--;
	        }
	       int start_days =11/*26*/; 
	       String seasonDateStr = years_value+"-"+start_month+"-"+start_days; 
	       Date seasonDate=new Date();
			try {
				seasonDate = changeStringToDate(seasonDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	       return seasonDate; 
	        
	   }
    /**
     * 获取某年某月的最后一天
     * @author zxg
     * @param year 年
     * @param month 月
     * @return 最后一天
     */ 
   public static int getLastDayOfMonth(int year, int month) { 
         if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 
                   || month == 10 || month == 12) { 
               return 31; 
         } 
         if (month == 4 || month == 6 || month == 9 || month == 11) { 
               return 30; 
         } 
         if (month == 2) { 
               if (isLeapYear(year)) { 
                   return 29; 
               } else { 
                   return 28; 
               } 
         } 
         return 0; 
   } 
   
  
   /**
    * 计算2个日期中间间隔的时间
    */
   public static int getIntervalDays(Date startday,Date endday){
	   if(startday.after(endday)){ 
           Date cal=startday; 
           startday=endday; 
           endday=cal; 
       }        
       long sl=startday.getTime(); 
       long el=endday.getTime();       
       long ei=el-sl;           
       return (int)(ei/(1000*60*60*24)+1); 
   }

   /**
    * 是否闰年
    * @author zxg
    * @param year 年
    * @return 
    */ 
  public static boolean isLeapYear(int year) { 
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0); 
  } 
  /**
	 * 获取当天的最后一秒
	 * @return
	 */
	  public static Date getDayLastSecond(){
		Date targetDate = new Date();
		String dateStr = dateToString(targetDate);
		try {
			targetDate = changeStringToDate(dateStr+" 23:59:59","yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("targetDate:"+targetDate);
		return targetDate;
	  }
/**
* 获取当天的第一秒
* @return
*/
public static Date getDayFirstSecond(){
	Date targetDate = new Date();
	String dateStr = dateToString(targetDate);
	try {
		targetDate = changeStringToDate(dateStr+" 00:00:00","yyyy-MM-dd HH:mm:ss");
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return targetDate;
}
	/**
	 * date:2012-12-01||2012-12-31
	 * type:第一天：10   最后一天：20；
	 * getDayFirstLast(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param type
	 * @return 
	 *Date
	 * @throws ParseException 
	 * @exception 
	 * @since  1.0.0
	 */
	public static Date getDayFirstLast(Date dateParm,String type) throws ParseException{
		Date targetDate = new Date();
		String dateStr=dateToString(dateParm);
		if("10".equals(type)){
			targetDate = changeStringToDate(dateStr+" 00:00:00","yyyy-MM-dd HH:mm:ss");
			return targetDate;
		}else if("20".equals(type)){
			targetDate = changeStringToDate(dateStr+" 23:59:59","yyyy-MM-dd HH:mm:ss");
			return targetDate;
		}else{
			return new Date();
		}
	}
	public static Date nextday(){
		Date date = new Date();
	   Calendar calendar = GregorianCalendar.getInstance();
	   calendar.setTime(date);
	   calendar.add(Calendar.DATE, 1);
	   date = calendar.getTime();
	   return date;
	}
	/**
	 * 根据参数得到指定时间段后的一天
	 * nextDayByType(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param day
	 * @return 
	 *Date
	 * @exception 
	 * @since  1.0.0
	 */
	public static Date nextDayByType(int day){
	   Date date = new Date();
	   Calendar calendar = GregorianCalendar.getInstance();
	   calendar.setTime(date);
	   calendar.add(Calendar.DATE, day);
	   date = calendar.getTime();
	   return date;
	}
	public static Date nextDayByType(Date crruDate, int day){
		   Calendar calendar = GregorianCalendar.getInstance();
		   calendar.setTime(crruDate);
		   calendar.add(Calendar.DATE, day);
		   crruDate = calendar.getTime();
		   return crruDate;
		}
	/*
	 * 单元测试
	 */
	@Test
	public void dateExample(){
//		System.out.println("获得下季度第一天 :"+getNextSeasonFirstDay(4));
//		System.out.println("获得本季度首月的26号:"+getSeasonTwentySix(1,true));
//		System.out.println("获得上季度首月的26号:"+getSeasonTwentySix(1,false));
//		
//		System.out.println("获得本季度的第一天和最后一天:"+getSeasonFirstEndDay(10,true));
//		System.out.println("获得上季度的第一天和最后一天:"+getSeasonFirstEndDay(10,false));
	}
	@Test
	public void currMonth(){
		String str =  "" ;
        SimpleDateFormat sdf= new  SimpleDateFormat( "yyyy-MM-dd" );
        Calendar lastDate = Calendar.getInstance();
        int month=lastDate.get(Calendar.MONTH); 
        str=sdf.format(lastDate.getTime());
//        System.out.println("month :"+month);
//		String dayStr=getSeasonFirstEndDay(9,true);
//		String str[]=dayStr.split(";");
//		try {
//			System.out.println("str[0] :"+changeStringToDate(str[0]));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("str[1] :"+str[1]);
	}
	@Test
	public void dateTest() throws ParseException{
		System.out.println("获得下季度第一天 :"+dateToString(nextDayByType(changeStringToDate("2013-01-02 14:30:30", "yyyy-MM-dd HH:mm:ss"),12),"yyyy-MM-dd HH:mm:ss"));
	}


}
