package service.Impl;

import dao.Impl.PageDao;
import pojo.PageBean;
import pojo.User;
import service.IPageService;

public class PageService implements IPageService {
     PageDao pd = new PageDao();
	@Override
	/**
	 * 得到所有好友
	 */
	public <T> void getAll(PageBean<T> pageBean, User user) {
          	pd.getAll(pageBean, user);
	}

	@Override
	public int totalCount(User user) {
		return  pd.getTotalCount(user);
	}

}
