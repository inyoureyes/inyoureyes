package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.PageBean;
import pojo.RelationShip;
import pojo.User;
import service.Impl.CheckUser;
import service.Impl.PageService;
import service.Impl.UserService;

public class UserLogin extends HttpServlet {
	private UserService userService = new UserService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    String method = request.getParameter("method");
		    if("Login".equals(method)){
		    	Login(request, response);
		    }else if("register".equals(method)){
		    	register(request, response);
		    }else if("getNickName".equals(method)){
		    	getNickName(request, response);
		    }
	}

    /**
     * 登陆页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	public void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String userName = request.getParameter("userName");
            String passWord  = request.getParameter("passWord");
            User user = new User();
            PageBean pageBean = new PageBean();
            PageService pageService = new PageService();
            boolean flag = userService.validationUser(userName, passWord);
            if(flag){
               user.setUserName(userName);
               user =  userService.finByUserName(userName);
               pageService.getAll(pageBean, user);
               List<RelationShip> friendList = pageBean.getDataList();
               request.setAttribute("pageBean", pageBean);
               request.getSession().setAttribute("userInfo",user);
               request.getSession().setAttribute("friendList", friendList);
               request.getRequestDispatcher("/jsp/friendList.jsp").forward(request, response);
               
            }else{
            	request.setAttribute("error", "您输入的用户名或密码不正确");
            	request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
            
	}
	/**
	 * 注册页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            String userName = request.getParameter("userName");
            String passWord = request.getParameter("passWord");
            String passWord2 = request.getParameter("passWord2");
            User user = new User();
            boolean flag = CheckUser.checkPassWord(passWord)&& CheckUser.checkUserName(userName);//检查用户账号密码格式
	        if(flag){
	        	if((userService.finByUserName(userName))==null){
	        		 if(passWord.equals(passWord2)){
	        			  user.setUserName(userName);
		        		  user.setPassWord(passWord);
		        		  userService.addUser(user);
		        		  User u = userService.finByUserName(userName);
		        		  request.getSession().setAttribute("user", u);
		        		  request.getRequestDispatcher("/jsp/setNickName.jsp").forward(request, response);
	        		 }else{
	        			  request.setAttribute("error", "两次输入的密码不相同！");
		        		  request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
	        		 }
	        	   }else{
	        		   request.setAttribute("error", "用户名已存在");
	        		   request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
	        	   }
	        	}else{
	        		    request.setAttribute("error", "用户名或密码格式不正确！");
		        	    request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
	        	}
	    }
	        	
	       
 
   
	
//	public PageBean<User> page(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//            String currpage = request.getParameter("currpage");
//            if(currpage==null||"".equals(currpage.trim())){
//            	currpage="1";
//            }
//            int currenPage = Integer.parseInt(currpage);
//            PageBean<User> pageBean = new PageBean<User>();
//            pageBean.setCurrenPage(currenPage);
//            return pageBean;
//	}
	/**
	 * 用户设置网名
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getNickName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	         String nickName = request.getParameter("nickName");
	         String mood = request.getParameter("mood");
	         User user =  (User) request.getSession().getAttribute("user");
	         userService.upDateNickName(nickName, user);
	         userService.upDateMood(mood, user);
	         User u =userService.finByUserName(user.getUserName());
	         request.setAttribute("userInfo", u);
	         request.getRequestDispatcher("/jsp/friendList.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           this.doGet(request, response);
	}

}
