package dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import pojo.PageBean;
import pojo.RelationShip;
import pojo.User;
import Utils.GetConnection;
import dao.IpageDao;

public class PageDao implements IpageDao {

	
	/**
	 * 查找所有好友信息
	 * @param <T>
	 */
	public <T> void getAll(PageBean<T> pageBean,User user) {
         int totalCount = this.getTotalCount(user);  //得到总信息数
         pageBean.setTotalCount(totalCount);            //设置到pageBean对象
         if(pageBean.getCurrenPage()<=0){
        	 pageBean.setCurrenPage(1);
         }else if(pageBean.getCurrenPage()>pageBean.getTotalPage()){
        	 pageBean.setCurrenPage(pageBean.getTotalPage());
         }
         int currenPage = pageBean.getCurrenPage();
         int index = (currenPage -1) * pageBean.getPageCount();
         int count = pageBean.getPageCount();
         int user_id = user.getUserId();
         QueryRunner qr = GetConnection.getConnection();
         String sql = "select * from t_user,t_relationship where t_relationship.friend_id=t_user.userId and t_relationship.userId=? and t_relationship.status=1 limit ?,?";
//         Object param[] = {user_id,index,count};
         try {
		 List<User> friednList = qr.query(sql, new BeanListHandler<User>(User.class),user_id,0,count);
		 pageBean.setDataList((List<T>) friednList);
         } catch (SQLException e) {
			e.printStackTrace();
		}
         
	}


	/**
	 * 得到总信息数
	 */
	public int getTotalCount(User user) {
     	QueryRunner qr = GetConnection.getConnection();
     	int user_id = user.getUserId();
     	Long count = null;
		try {
			String sql = "select count(*) from t_user,t_relationship where t_relationship.friend_id=t_user.userId and t_relationship.userId=? and status=1";
			Object param[] = {user_id};
			count = qr.query(sql,new ScalarHandler<Long>(),param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count.intValue();
	}
  @SuppressWarnings("unchecked")
public static <T> void main(String[] args) {
	PageDao pd = new PageDao();
	PageBean<RelationShip> pagebean = new PageBean();
	User user = new User();
	pagebean.setCurrenPage(1);
	user.setUserId(2);
	pd.getAll(pagebean, user);
	List<T> list =  (List<T>) pagebean.getDataList();
	for (T in: list) {
		System.out.println(in);
	}
 }

}
