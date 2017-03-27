package dao.Impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import pojo.User;
import Utils.GetConnection;
import dao.IFrinedDao;

public class FriendDao implements IFrinedDao {
   
	public void addFriend(String UserNumber,User user) {
	 QueryRunner qr = GetConnection.getConnection();
	  User friend =  queryByNum(UserNumber); //获取查找到的朋友id
	  int friend_id =  friend.getUserId();
	  int user_id = user.getUserId();
	  String sql = "insert into t_relationship(userid,friend_id,status) value(?,?,?)";
	  Object param[] = {user_id,friend_id,1};
	  try {
		qr.update(sql, param);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	@Override
	/**
	 * 删除好友，设置一个标记来作为假删除
	 */
	public void deleteFriend(String UserNumber,User user) {
        QueryRunner qr = GetConnection.getConnection();
        User friend = queryByNum(UserNumber);
        int friend_id = friend.getUserId();
        int user_id = user.getUserId();
        String sql = "update t_relationship set status=0 where userId=? and friend_id=?";
        Object param[] ={user_id,friend_id};
        try {
			qr.update(sql, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public User queryByNum(String friendNumber) {
	    User result = null;
	    List<User> list = null;
		QueryRunner qr = GetConnection.getConnection();
		String sql = "select * from t_user where UserNumber=?";
		try {
			Object param[] = {friendNumber};
			list = qr.query(sql, new BeanListHandler(User.class),param);
			Iterator<User> it = list.iterator();
		    while(it.hasNext()){
		    	result = it.next();
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	/**
	 * 判断好友存不存在
	 */
	@Override
	public boolean friendExist(User user, int friend_id) {
		boolean flag = false;
	    QueryRunner qr = GetConnection.getConnection();
	    int userId = user.getUserId();
	    String sql = "select * from t_relationship where userId=? and friend_id=?";
	    try {
			user = qr.query(sql, new BeanHandler<User>(User.class),userId,friend_id);
		    if(user!= null){
		    	flag = true;
		    }
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 恢复删除的好友
	 */
	@Override
	public void friendRecovery(User user, int friend_id) {
      QueryRunner qr = GetConnection.getConnection();
      int userId = user.getUserId();
      String sql = "update t_relationship set status=1 where userId=? and friend_id=? ";
      Object param[] = {userId,friend_id};
      try {
		qr.update(sql, param);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
//	
//	public static void main(String[] args) {
//	User user = new  User();
//	user.setUserId(2);
//	int friend_id=3;
//	FriendDao fd = new FriendDao();
//	fd.friendRecovery(user, friend_id);
//}
}
