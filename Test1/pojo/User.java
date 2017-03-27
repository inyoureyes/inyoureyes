package pojo;
/**
 * 用户信息
 * @author Administrator
 *
 */
public class User {
   private int userId;
   private String userName;
   private String passWord;
   private String userNumber;
   private String nickName;   //昵称
   private String mood;       //心情
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}

public String getUserNumber() {
	return userNumber;
}
public void setUserNumber(String userNumber) {
	this.userNumber = userNumber;
}
public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public String getMood() {
	return mood;
}
public void setMood(String mood) {
	this.mood = mood;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", passWord="
			+ passWord + ", UserNumber=" + userNumber + ", nickName="
			+ nickName + ", mood=" + mood + "]";
}



   
}  
