package service.Impl;

import dao.Impl.FriendDao;
import pojo.User;
import service.IFriendService;

public class FriendService implements IFriendService{
     FriendDao fd = new FriendDao();
	@Override
	/**
	 * 添加好友
	 */
	public void addFriend(String UserNumber, User user) {
        	fd.addFriend(UserNumber, user);	
	}

	@Override
	/**
	 * 删除好友
	 */
	public void deleteFriend(String userNumber, User user) {
           fd.deleteFriend(userNumber, user);		
	}

	@Override
	/**
	 * 按照好友Number查找好友
	 */
	public User queryByNumber(String number) {
  		return fd.queryByNum(number);
	}

	@Override
	public boolean friendExist(User user, int friend_id) {
		return fd.friendExist(user, friend_id);
	}

	@Override
	public void friendRecovery(User user, int friend_id) {
      fd.friendRecovery(user, friend_id);
	}
    
}
