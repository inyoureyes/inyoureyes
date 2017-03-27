package service;

import pojo.User;

public interface IFriendService {
    /**
     * 添加好友
     * @param UserNumber
     * @param user
     */
	public void addFriend(String UserNumber,User user);
	/**
	 * 删除好友
	 * @param userNumber
	 * @param user
	 */
	public void deleteFriend(String userNumber,User user);
	/**
	 * 按照number查找好友
	 * @param number
	 * @return
	 */
	public User queryByNumber(String number);
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
