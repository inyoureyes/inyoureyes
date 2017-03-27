package service.Impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 检查用户名和密码是否合法
 * @author Administrator
 *
 */
public class CheckUser {
    /**
     * 检查用户名格式
     * @param userName
     * @return
     */
	public static  boolean checkUserName(String userName){
	   boolean flag = false;
	   String check = "[a-zA-Z]{1}[a-zA-Z0-9_]{1,15}";
	   Pattern regex = Pattern.compile(check);
	   Matcher matcher = regex.matcher(userName);
	   if(matcher.matches()){
		   flag = true;
	   }
	   return flag;
   }
   /**
    * 检查密码格式
    * @param passWord
    * @return
    */
	public static  boolean checkPassWord(String passWord){
	   boolean flag = false;
	   String check = "[a-zA-Z0-9]{1,16}";
	   Pattern regex = Pattern.compile(check);
	   Matcher matcher = regex.matcher(passWord);
	   if(matcher.matches()){
		   flag = true;
	   }
	   return flag;
   }
}
