package dao;

import pojo.User;

public interface IFrinedDao {
    /**
     * 添加朋友
     * @param friend
     */
	void  addFriend(String UserNumber,User user);
	/**
	 * 删除好友
	 * @param friend
	 */
	void deleteFriend(String  UserNumber,User user);
	/**
	 * 按照盆友number查找
	 * @param friendNumber
	 * @return
	 */
	 User queryByNum(String friendNumber);
	 /**
	  * 判断好友存不存在
	  * @param user
	  * @param friend_id
	  * @return
	  */
	 boolean friendExist(User user,int friend_id);
	 /**
	  * 恢复删除的好友
	  * @param user
	  * @param friend_id
	  */
	 void  friendRecovery(User user,int friend_id);



}
