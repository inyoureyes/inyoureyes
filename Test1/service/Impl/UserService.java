package service.Impl;

import java.util.List;

import pojo.User;
import service.IUserService;
import dao.Impl.UserDao;

public class UserService implements IUserService {

    UserDao ud = new UserDao();
	/**
	 * 添加用户名
	 */
    public void addUser(User user) {
        ud.addUser(user);
	}

	/**
	 * 检查用户名是否存在
	 */
	public boolean checkUser(String userName) {
		return ud.checkUser(userName);
	}

	/**
	 * 验证用户名密码是否正确
	 */
	public boolean validationUser(String userName, String passWord) {
		return ud.validationUser(userName, passWord);
	}

	/*检查用户Number是否重复
	 * (non-Javadoc)
	 * @see service.IUserService#checkNumber(java.lang.String)
	 */
	public boolean checkNumber(String number) {
		return ud.checkNumber(number);
	}

    /**
     * 更新昵称
     */
	@Override
	public void upDateNickName(String nickName, User user) {
           ud.upDateNickName(nickName, user);		
	}

    /**
     * 更新心情
     */
	@Override
	public void upDateMood(String mood, User user) {
           ud.upDateMood(mood, user);		
	}

	public List<User> findById(User user) {
		return ud.findById(user);
	}

	@Override
	public User finByUserName(String userName) {
		
		return ud.finByUserName(userName);
	}

	@Override
	public User findByUserNumber(String userNumber) {
		
		return ud.findByUserNumber(userNumber);
	}
    
}
