package com.tyust.common;
import java.io.IOException;
import java.util.Date;
public class CardID {
 /**
 * 验证证件号码的合法性 参数必须是18位的字符串
  * @param s
  * @return
  */
	public static boolean checkCardID(String s){
	boolean b = false;
	 if(s.charAt(17)==getSecurityCode(s)){
		 b = true;
	 }
	 return b;
 }
 /**
  * 15位转换成18位的
  * @param s
  * @return
  */
 public static String Convert(String s) throws IOException {

  StringBuffer result;

  StringBuffer sad = new StringBuffer(s);

  sad.insert(6, "19");

  result = sad.append(getSecurityCode(sad.toString()));

  return result.toString();
 }
 /**
  * 返回验证码（身份证最后一位）
  * @param s
  * @return
  */
  static char getSecurityCode(String s) {

	  String M = new String(s);

      int[] pp = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };  //将前面的身份证号码17位数分别乘以不同的系数，这个就是系数的数组

	  char[] yy = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' }; //加出来和除以11，看余数是多少？余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2

	  int mm = 0;

	  for(int i = 0;i < 17; i++){

		  mm+=pp[i]*Integer.parseInt(M.substring(i, i + 1));
	  }

	  mm = mm % 11;

	  return yy[mm];
	 }
 /**
  * 获取个人信息(出生日期、性别)
  * @param s
  * @return
  */
 public static String[] getInfo(String s) {
  String M = new String(s);
  String y = M.substring(6, 10);
  String m = M.substring(10, 12);
  String d = M.substring(12, 14);
 // System.out.println("该居民出生地：" + M.substring(0, 6));
   String[] callback = new String[5];
   //System.out.println("该居民出生时间为：" + y + "年" + m + "月" + d + "日");
   callback[0]=y;
   callback[1]=m;
   callback[2]=d;
   int sex = 0;
   try{
	   sex = Integer.parseInt(M.substring(16,17));
	   if (sex % 2 == 0){
	//	   System.out.println("该居民为：女性");
		   callback[3]="1";
		  }else{
		//	  System.out.println("该居民为：男性");
			  callback[3]="0";
		  }
   }catch(Exception e){
	   
   }
  
  return callback;
 }
/**
 * 判断出生日期是否正确
 * @param s
 * @return
 */
 public static boolean isBirthday(String s){

	 boolean b = true;

	 if(s.length() == 15){

		 StringBuffer sb = new StringBuffer(s);

		 s = sb.insert(6, "19").toString();
	 }
	 String M = new String(s);

	 int y = 0;
	 int m = 0;
	 int d = 0;
	 try{
	   y = Integer.parseInt(M.substring(6, 10));
	   m = Integer.parseInt(M.substring(10, 12));
	   d = Integer.parseInt(M.substring(12, 14));
	 }catch(Exception e){
		 return false;
	 }
	  if (y < 1900 || m < 1 || m > 12 || d < 1 || d > 31

	    || ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) ||

	    (m == 2 && ((y % 4 > 0 && d > 28) || d > 29)))

	  {
	   b = false;
	  }
	 return b;
 }
 /**
  * 判断身份证是否合法 如果合法 返回年龄,15位自动变为18位
  * @param cardid
  * @return
  * 修改返回值---赵静
  * 若为2010年出生，返回值也为0，但身份证验证为不合法，修改返回值，若身份证不合法，则返回-1
  */
 public static int isCardID(String cardid) {
	 if(cardid.length()==15){
		 try {
			cardid = Convert(cardid);
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	 }
	 if(cardid.length()==18){
		if(isBirthday(cardid)){
			if(checkCardID(cardid)){
				String[] info = getInfo(cardid);
				String d = new Date().toString();
				int dy = Integer.parseInt(d.substring(d.length()-4,d.length()));
				int by = Integer.parseInt(info[0]);
				return dy-by;
			}
		}
	 }
	 return -1;
 }
 /**
  * 这个不自动升级为18位
  *
  */
 public static int isCardIDTwo(String cardid) {
	 if(cardid.length()==18){
		if(isBirthday(cardid)){
			if(checkCardID(cardid)){
				String[] info = getInfo(cardid);
				String d = new Date().toString();
				int dy = Integer.parseInt(d.substring(d.length()-4,d.length()));
				int by = Integer.parseInt(info[0]);
				return dy-by;
			}
		}
	 }
	 return 0;
 }

}



















