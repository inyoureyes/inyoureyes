package dao;
import java.util.List;

import pojo.User;
public interface IUserDao {
    /**
     * 添加用户
     */
	public void addUser(User user);
	/**
	 * 判断用户名是否已存在
	 * @param userName
	 * @return
	 */
	public boolean checkUser(String userName);
	/**
	 * 验证用户名或密码是否正确
	 * @return
	 */
	public boolean validationUser(String userName,String passWord);
	/**
	 * 检查用户Number是否相同
	 * @param user
	 * @return
	 */
	public boolean checkNumber(String number);
	
	//设置昵称和心情，更改昵称和心情
	/**
	 * 设置/更改昵称
	 * @param nickName
	 * @param user
	 */
	public void upDateNickName(String nickName,User user);
	/**
	 * 设置/更改心情
	 * @param Mood
	 * @param User
	 */
	public void upDateMood(String Mood,User User);
	/**
	 * 根据ID查找用户
	 * @param id
	 * @return
	 */
	List<User> findById(User user);
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	User finByUserName(String userName);
	/**
	 * 根据用户Number查找用户
	 * @param user
	 * @return
	 */
	User findByUserNumber(String userNumber);
	
}
