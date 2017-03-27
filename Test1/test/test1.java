package test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pojo.User;
import Utils.GetConnection;

public class test1 {
	public User queryByNum(String friendNumber) {
	    User result = null;
	    List<User> list = null;
		QueryRunner qr = GetConnection.getConnection();
		String sql = "select * from t_user where user_id=1";
		
		return result;
		
	}
  public static void main(String[] args) {
	test1 t = new test1();
	User user = new User();
	t.queryByNum("1");
	System.out.println(user);
	
}
}
