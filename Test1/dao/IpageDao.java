package dao;

import pojo.PageBean;
import pojo.User;


/**
 * 分页接口
 * @author Administrator
 *
 */
public interface IpageDao {
    /**
     * 查找所有信息
     * @param <T>
     * @param pb
     */
	public <T> void getAll(PageBean<T> pageBean,User user);
	/**
	 * 得到总信息量
	 * @return
	 */
	public int getTotalCount(User user);
}
