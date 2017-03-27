package service;

import java.util.List;

import pojo.User;
/**
 * Service层用户方法
 * @author Administrator
 *
 */
public interface IUserService {
  /**
   * 添加用户
   * @param user
   */
	public void addUser(User user);
	/**
	 * 判断用户是否存在
	 * @param userName
	 * @return
	 */
	public boolean checkUser(String userName);
	/**
	 * 验证用户密码是否正确
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public boolean validationUser(String userName,String passWord);
	/**
	 * 检查用户Number是否相同
	 * @param number
	 * @return
	 */
	public boolean checkNumber(String number);
	/**
	 * 设置/更新昵称
	 * @param nickName
	 * @param user
	 */
	public void upDateNickName(String nickName,User user);
	/**
	 * 设置/更新心情
	 * @param mood
	 * @param user
	 */
	public void upDateMood(String mood,User user);
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
