package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.PageBean;
import pojo.User;
import service.Impl.FriendService;
import service.Impl.PageService;
import service.Impl.UserService;
/**
 * 用户功能（CRDU）
 * @author Administrator
 *
 */
public class Function extends HttpServlet {
   private UserService userService = new UserService();
   private FriendService friendService = new FriendService();
   private PageBean pageBean = new PageBean();	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    String method = request.getParameter("method");
		    String op = request.getParameter("op");
		    if("add".equals(op)){
		    	String userNumber = request.getParameter("userNumber");
		        int friend_id =Integer.parseInt(request.getParameter("userId"));
		    	addFriend(request, response,userNumber,friend_id);
		    }else if("delete".equals(op)){
		    	String userNumber = request.getParameter("userNumber");
		    	delete(request, response, userNumber);
		    	
		    }
		    if("findFriend".equals(method)){
		    	//查找好友
		    	findFriend(request, response);
		    }
		    

	}
	/**
	 * 查找好友
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public User findFriend(String userNumber,String userName){
		 User user = new User();
         user = userService.findByUserNumber(userNumber);
         return user;
	}
	public void findFriend(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String userNumber = request.getParameter("number");
            User user = new User();
            user = userService.findByUserNumber(userNumber);
            request.setAttribute("friend", user);
            request.getRequestDispatcher("/jsp/friendList.jsp").forward(request, response);
	}
	/**
	 * 添加好友
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addFriend(HttpServletRequest request, HttpServletResponse response,String userNumber,int friend_id)
			throws ServletException, IOException {
		    User user = (User) request.getSession().getAttribute("userInfo");
		    boolean flag = friendService.friendExist(user, friend_id);
		    if(!(user.getUserId()==friend_id)){
		     if(!flag){
		     friendService.addFriend(userNumber, user);
             List<User> friendList = page.getList(request, response, user);
		     request.getSession().setAttribute("friendList",friendList);
             request.getRequestDispatcher("/jsp/friendList.jsp").forward(request, response);
		     }else{
			   friendService.friendRecovery(user, friend_id);
			   List<User> friendList = page.getList(request, response, user);
			   request.getSession().setAttribute("friendList",friendList);
	           request.getRequestDispatcher("/jsp/friendList.jsp").forward(request, response);
		   }
		 }else{
			 request.setAttribute("error", "您不能添加自己为好友");
			 request.getRequestDispatcher("/jsp/friendList.jsp").forward(request, response);
		 }
   }
	/**
	 * 删除好友
	 * @param request
	 * @param response
	 * @param userNumber
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response,String userNumber)
			throws ServletException, IOException {
	        User user = (User)request.getSession().getAttribute("userInfo");//得到当前登陆的用户的信息
	        friendService.deleteFriend(userNumber, user);
	        List<User> friendList = page.getList(request, response, user);
	        request.getSession().setAttribute("friendList",friendList);
	        request.getRequestDispatcher("/jsp/friendList.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            this.doGet(request, response);
		
	}

}
