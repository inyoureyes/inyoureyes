package service;

import pojo.PageBean;
import pojo.User;
/**
 * 分页Service层接口
 * @author Administrator
 *
 */
public interface IPageService {
    /**
     * 查找所有信息
     * @param pageBean
     * @param user
     */
	public <T> void  getAll(PageBean<T> pageBean,User user);
	/**
	 * 查询信息总数
	 * @param user
	 * @return
	 */
	public int totalCount(User user);
	
} 
