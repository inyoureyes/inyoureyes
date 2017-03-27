package action;

import java.io.IOException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.PageBean;
import pojo.User;
import service.Impl.PageService;

public class page extends HttpServlet {
    private static PageBean pageBean = new PageBean();
	

   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	  String method = req.getParameter("method");
    	  if("method".equals(method)){
    		 String currpage = req.getParameter("curenPage");
    		 page(req, resp,currpage);
    	  }
    }
    public static  PageBean<User> page(HttpServletRequest request, HttpServletResponse response,String currpage)
			throws ServletException, IOException {
        if(currpage==null||"".equals(currpage.trim())){
        	currpage="1";
        }
        int currenPage = Integer.parseInt(currpage);
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setCurrenPage(currenPage);
        return pageBean;
		
	}
	public static  List<User> getList(HttpServletRequest request, HttpServletResponse response,User user)
			throws ServletException, IOException {
		 PageService pageService = new PageService();
         pageService.getAll(pageBean, user);
         List<User> friendList = pageBean.getDataList();
         return friendList;
	}
	 protected void post(HttpServletRequest req, HttpServletResponse resp)
	    		throws ServletException, IOException {
	    	this.doGet(req, resp);
	    }
}
