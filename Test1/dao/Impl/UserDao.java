package dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pojo.User;
import Utils.GetConnection;
import dao.IUserDao;

public class UserDao implements IUserDao {
    Connection conn = null;
    
	/**
	 * 注册用户
	 */
    @Override
	public void addUser(User user ) {
	   QueryRunner qr = GetConnection.getConnection();
       Integer ran = Number.getNumber();
       user.setUserNumber(""+ran);
       String sql = "insert into t_user(userName,passWord,UserNumber) values(?,?,?)";
	   Object param[] = {user.getUserName(),user.getPassWord(),user.getUserNumber()};
       try {
		qr.update(sql, param);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}

	@Override
	/**
	 * 判断用户名是否已存在
	 */
	public boolean checkUser(String userName) {
		boolean flag = false;
		QueryRunner qr = GetConnection.getConnection();
		try {
			String sql = "select * from t_user where userName=?";
			Object param[] = {userName};
			List<User> nameList =  qr.query(sql, new BeanListHandler<User>(User.class),param);
			Iterator<User> it = nameList.iterator();
			if(it.hasNext()){
				flag = true;
			}else{
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return flag;
	}

	@Override
	/**
	 * 验证用户名或密码是否正确
	 */
	public boolean validationUser(String userName, String passWord) {
		boolean flag = false;
		QueryRunner qr = GetConnection.getConnection();
		try {
			String sql = "select * from t_user where userName=? and passWord=?";
			Object param[] = {userName,passWord};
			List<User> result = qr.query(sql, new BeanListHandler<User>(User.class),param);
			Iterator<User> it = result.iterator();
			if(it.hasNext()){
				flag = true;
			}else{
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
   /**
    * 检查用户Number是否相同
    */
	public boolean checkNumber(String number) {
		boolean flag = false;
		QueryRunner qr = GetConnection.getConnection();
		String sql = "select UserNumber from t_user where UserNumber=?";
		Object param[] = {number};
		  try {
		 List<User> numList = qr.query(sql, new BeanListHandler<User>(User.class),param);
		 Iterator<User> it =numList.iterator();
		 if(it.hasNext()){
			 flag = false;
		 }else{
			 flag = true;
		 }
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return flag;
	}

@Override
/**
 * 设置昵称
 */
public void upDateNickName(String nickName,User user) {
	QueryRunner qr = GetConnection.getConnection();
	String sql = "update t_user set nickName=? where userId=?";
    int user_id = user.getUserId();
    Object param[] = {nickName,user_id};
    try {
		qr.update(sql,param);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

@Override
/**
 * 设置心情
 */
public void upDateMood(String Mood, User user) {
    QueryRunner qr = GetConnection.getConnection();
    String sql = "update t_user set mood=? where userId=?";
    int user_id = user.getUserId();
    Object param[] = {Mood,user_id};
    try {
		qr.update(sql, param);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

/**
 * 按照ID查找
 */
public List<User> findById(User user) {
    QueryRunner qr = GetConnection.getConnection();
    String sql = "select * from t_user where userId=?";
    User friend = null;
    List<User> list = null;
    try {
	 list = qr.query(sql, new BeanListHandler<User>(User.class),friend);

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}

 /**
  * 按照用户名查找
  */
 public User finByUserName(String userName) {
	QueryRunner qr = GetConnection.getConnection();
	String sql = "select * from t_user where userName=? ";
	User user = null;
	try {
		user =  qr.query(sql, new BeanHandler<User>(User.class),userName);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return user;
}

  /**
   * 根据用户Number查找用户
   */
  public User findByUserNumber(String userNumber) {
	 QueryRunner qr = GetConnection.getConnection();
	 String sql = "select * from t_user where userNumber=?";
	 User user = null; 
	 try {
	 user = qr.query(sql, new BeanHandler<User>(User.class),userNumber);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return user;
}

}
