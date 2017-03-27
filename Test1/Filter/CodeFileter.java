package Filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 全局文字编码过滤
 * @author Administrator
 *
 */
public class CodeFileter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
        	final HttpServletRequest request = (HttpServletRequest)req;	
        	      HttpServletResponse response = (HttpServletResponse)res;
        	      //公共处理方法
        	      request.setCharacterEncoding("utf-8");
        	      response.setContentType("text/html;charset=utf-8");
        	      //创建代理器
        	    HttpServletRequest proxy = (HttpServletRequest)Proxy.newProxyInstance(
        	    		   request.getClass().getClassLoader(),  //加载类
        	    		   new Class[]{HttpServletRequest.class},   //对目标接口实现
        	    		   new InvocationHandler() {             //事件处理器
								public Object invoke(Object proxy, Method method, Object[] args)
									throws Throwable {
									//方法返回值
									Object returnValue = null;
									String methodName = method.getName();//得到getParameter方法名
									if("getParameter".equals(methodName)){
										String value = request.getParameter(args[0].toString());
										String methodSubmit = request.getMethod();
										if("GET".equals(methodSubmit)){
											if(value!=null && !"".equals(value.trim())){
												
											}
										}
									   return value;
									}else{
										returnValue = method.invoke(request, args);
									}
									
									
									
									return returnValue;
								}
											});
	    chain.doFilter(proxy, response);
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
